UpdateItemSpec updateItemSpec = new UpdateItemSpec()
    .withPrimaryKey("id", "91c2b60d-c428-403c-be42-8657b4f20669")
    .withUpdateExpression("set customAttributes.#occupation = :value")
    .withNameMap(new NameMap().with("#occupation", "occupation"))
    .withValueMap(new ValueMap().withString(":value", "Programmer"))
    .withReturnValues(ReturnValue.ALL_NEW);

UpdateItemOutcome outcome = table.updateItem(updateItemSpec);

System.out.println(outcome.getItem().toJSONPretty());