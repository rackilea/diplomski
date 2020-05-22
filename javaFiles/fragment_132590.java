Map questionDetails = new HashMap<>();
questionDetails.put("label", descriptionNode.getText());
Map validations = new HashMap<>();
validations.put("compulsary", 1)
questionDetails.put("validations", validations);
System.out.println(new Gson().toJson(questionDetails));