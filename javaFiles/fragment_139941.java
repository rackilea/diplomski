task executeSqlScriptRunnerBeforeTenantCreation(type:JavaExec) {
    description "Execute ssr.runner to install certificates into the device"

    if(scriptRunnerVariables.get('SSR_INTERSECT_MOCK') == 'true') {
        println "Configuring SQL Script Runner..."
        println "Adding certificates for mocked intersect service"

        if(scriptRunnerVariables.get('SSR_DB_TYPE') == 'SQL_SERVER') {
            main = '<FULLY QUALIFIED NAME OF CLASS YOU NEED TO RUN>' 
            classpath =  file("{$workingDir}\\ssr.runner.jar")            
            args '-dbtype', 
                 "${scriptRunnerVariables.get('SSR_DB_TYPE')}", 
                 '-dbhost', 
                 "${scriptRunnerVariables.get('SSR_DB_HOST')}", 
                 '-dbinstance', 
                 "${scriptRunnerVariables.get('SSR_DB_INSTANCE')}", 
                 '-dbname', 
                 "${scriptRunnerVariables.get('SSR_DB_NAME')}", 
                 '-dbuser', 
                 "${scriptRunnerVariables.get('SSR_DB_USER')}",
                 '-dbpass', 
                 "${scriptRunnerVariables.get('SSR_DB_PASS')}", 
                 '-sqlscriptpath', 
                 "${scriptRunnerVariables.get('SSR_INTERSECT_MOCK_DB_SCRIPT')}"  
            }
        }
    }
}