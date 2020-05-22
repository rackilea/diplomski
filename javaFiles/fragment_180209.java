//Prahaladd - operatorList returned would be null
 List<OperatorDetailsBean> operatorList = details.getOperators(term);
                                System.out.println("Operator List " + operatorList); 
//Prahaladd - GSON processes this null value.
JsonElement element = new Gson().toJsonTree(operatorList);

 System.out.println(element);
 //Prahaladd - this will fail since we are trying to process a non-array
 // as a JSON array.
 JsonArray jsonArray = element.getAsJsonArray();