Map<String, List<XmlInclude>> classToMethodsMap = new HashMap<String, List<XmlInclude>>();
        for (ITestResult testResult : failedTests){

            //Create map of failed classes to methods
            if(classToMethodsMap.get(testResult.getTestClass().getName()) == null){
                List<XmlInclude> methods = new ArrayList<XmlInclude>();
                methods.add(new XmlInclude(testResult.getMethod().getMethodName()));
                classToMethodsMap.put(testResult.getTestClass().getName(),methods);
            }else{
                classToMethodsMap.get(testResult.getTestClass().getName()).add(new XmlInclude(testResult.getTestClass().getName()));
            }
        }

        List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
        for(String className : classToMethodsMap.keySet()){
            XmlClass  xmlClassToAdd =new XmlClass(className);
            xmlClassToAdd.setIncludedMethods(classToMethodsMap.get(className));
            xmlClasses.add(xmlClassToAdd);

        }
        xmlTest.setXmlClasses(xmlClasses);
        suite.addTest(xmlTest);