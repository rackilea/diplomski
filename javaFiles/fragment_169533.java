import org.codehaus.groovy.grails.commons.GrailsDomainClass;
import org.codehaus.groovy.grails.scaffolding.*
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.FileSystemResource;
import grails.util.GrailsNameUtils

/**
 * Gant script that generates a service for a given domain class
 *
 * @author Martín Caballero
 *
 */

includeTargets << grailsScript("_GrailsBootstrap")

generateForName = null

target(generateServiceForOne: "Generates service for only one domain class.") {
    depends(loadApp)

    def name = generateForName
    name = name.indexOf('.') > 0 ? name : GrailsNameUtils.getClassNameRepresentation(name)
    def domainClass = grailsApp.getDomainClass(name)

    if (!domainClass) {
        grailsConsole.updateStatus "Domain class not found in grails-app/domain, trying hibernate mapped classes..."
        bootstrap()
        domainClass = grailsApp.getDomainClass(name)
    }

    if (domainClass) {
        generateServiceForDomainClass(domainClass)
        event("StatusFinal", ["Finished generation for domain class ${domainClass.fullName}"])
    }
    else {
        event("StatusFinal", ["No domain class found for name ${name}. Please try again and enter a valid domain class name"])
        exit(1)
    }
}

def generateServiceForDomainClass(domainClass) {
    UserInterfaceTemplateGenerator = classLoader.loadClass('plugin.ui.scaffold.UserInterfaceTemplateGenerator')
    def templateGenerator = UserInterfaceTemplateGenerator.newInstance(classLoader)
    templateGenerator.grailsApplication = grailsApp
    templateGenerator.pluginManager = pluginManager

    event("StatusUpdate", ["Generating service for domain class ${domainClass.fullName}"])
    templateGenerator.generateService(domainClass, basedir)
    event("GenerateServiceEnd", [domainClass.fullName])
}