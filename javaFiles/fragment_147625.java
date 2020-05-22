MultiValueMap<String, MethodDetails>  methodDetailsMap = projectDetails.getClassDetailsMap().get(0).getMethodDetailsMap();
       Set<String> methodNamesSet = methodDetailsMap.keySet();

        for(String str: methodNamesSet) {
                System.out.println(methodDetailsMap.get(str));
        }