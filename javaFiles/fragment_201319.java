project: 
 build: 
  plugins: 
   plugin: 
    executions: 
     execution: 
      id: "generate-common-sources"
      configuration: 
       wsdlOptions: # Keep this empty!
 profiles: 
  profile: 
   id: "env-test"
   build: 
    plugins: 
     plugin: 
      executions: 
       execution: 
        id: "generate-test-sources"
        configuration: 
         wsdlOptions: 
          wsdlOption: 
           - 
            wsdl: "${project.basedir}/src/main/resources/wsdl/Service1.wsdl"
            wsdlLocation: "/wsdl/Service1.wsdl"
           - 
            wsdl: "${project.basedir}/src/main/resources/wsdl/Service2.wsdl"
            wsdlLocation: "/wsdl/Service2.wsdl"
           - 
            wsdl: "${project.basedir}/src/main/resources/wsdl/Service3-test.wsdl"
            wsdlLocation: "/wsdl/Service3-test.wsdl"
  profile:
   id: "env-prod"
   build:
    # Duplicate env-test here