for (int counter = 0; counter < ids.size(); counter++) {
    tmp_rules = JsonPath.read(jsonFile, "$..orders[" + counter + "].rule");
    for (int counter2 = 0; counter2 < tmp_rules.size();counter2++){
        if (
                (JsonPath.read(jsonFile, "$..orders[" + counter + "].rule[" + counter2 + "]") == 1) &&
                (JsonPath.read(jsonFile, "$..orders[" + counter + "].asked[" + counter2 + "]")) != 0) {
                   end_id.add(JsonPath.read(jsonFile, "$..id[" + counter + "]"));
                   end_rule.add(JsonPath.read(jsonFile, "$..orders[" + counter + "].rule[" + counter2 + "]"));
                   end_asked.add(JsonPath.read(jsonFile,"$..orders[" + counter + "].asked[" + counter2 + "]"));
        }
    }
}