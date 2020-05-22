package plugin.ui.scaffold

import org.codehaus.groovy.grails.scaffolding.DefaultGrailsTemplateGenerator;
import grails.build.logging.GrailsConsole
import grails.util.BuildSettingsHolder
import groovy.text.SimpleTemplateEngine
import groovy.text.Template
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerAware
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.util.Assert
import org.springframework.core.io.AbstractResource
import org.codehaus.groovy.grails.scaffolding.SimpleDomainClassPropertyComparator
import org.codehaus.groovy.grails.scaffolding.DomainClassPropertyComparator

class UserInterfaceTemplateGenerator extends DefaultGrailsTemplateGenerator {
    public UserInterfaceTemplateGenerator(ClassLoader classLoader){
        super(classLoader)
    }

    void generateService(GrailsDomainClass domainClass, String destdir) {
        Assert.hasText destdir, "Argument [destdir] not specified"

        if (domainClass) {
            def fullName = domainClass.fullName
            def pkg = ""
            def pos = fullName.lastIndexOf('.')
            if (pos != -1) {
                // Package name with trailing '.'
                pkg = fullName[0..pos]
            }

            def destFile = new File("${destdir}/grails-app/services/${pkg.replace('.' as char, '/' as char)}${domainClass.shortName}Service.groovy")
            if (canWrite(destFile)) {
                destFile.parentFile.mkdirs()

                destFile.withWriter { w ->
                    generateService(domainClass, w)
                }

                LOG.info("Controller generated at ${destFile}")
            }
        }
    }

    void generateService(GrailsDomainClass domainClass, Writer out) {
        def templateText = getTemplateText("Service.groovy")

        boolean hasHibernate =pluginManager?.hasGrailsPlugin('hibernate')
        def binding = [pluginManager: pluginManager,
                       packageName: domainClass.packageName,
                       domainClass: domainClass,
                       className: domainClass.shortName,
                       propertyName: getPropertyName(domainClass),
                       comparator: hasHibernate ? DomainClassPropertyComparator : SimpleDomainClassPropertyComparator]

        def t = engine.createTemplate(templateText)
        t.make(binding).writeTo(out)
    }

    protected canWrite(File testFile) {
        if (!overwrite && testFile.exists()) {
            try {
                def response = GrailsConsole.getInstance().userInput("File ${makeRelativeIfPossible(testFile.absolutePath, basedir)} already exists. Overwrite?",['y','n','a'] as String[])
                overwrite = overwrite || response == "a"
                return overwrite || response == "y"
            }
            catch (Exception e) {
                // failure to read from standard in means we're probably running from an automation tool like a build server
                return true
            }
        }
        return true
    }

    protected String getPropertyName(GrailsDomainClass domainClass) { "${domainClass.propertyName}${domainSuffix}" }

}