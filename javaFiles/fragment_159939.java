StringBuilder finalResult = new StringBuilder();
        String[] results = allPlanningIds.split(",");
        for(String eachPlanningId : results){
            String[] resultPlanningIds = eachPlanningId.split(":");
            if(resultPlanningIds.length != 2){
                continue;
            }
            String result = "{" + resultPlanningIds[1];
            finalResult = finalResult.append(result + ",");
        }
        System.out.println(finalResult);