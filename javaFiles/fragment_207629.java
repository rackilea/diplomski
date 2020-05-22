task hibernate{
description "Generates Java Classes from the Database Schema."
group "Hibernate"

doLast{
    ant {
        def base = "$projectDir/src/main/java"

        taskdef(name: 'hibernatetool', 
            classname: 'org.hibernate.tool.ant.HibernateToolTask',
            classpath: configurations.compile.asPath )

        hibernatetool( destdir : "$base") { 

            // needs to be specified in order to find the java class
            classpath{
                path(location:"${buildDir}/classes/java/main/")
            }

            jdbcconfiguration(
                propertyfile:"src/main/resources/hibernate.properties", 
                reversestrategy:"mypackage.HibernateReverseEngineeringStrategy",
                packagename: springProperties["hibernate.generate.package"]
            ) 

            hbm2java(ejb3:true)
        } 
    }
}

}