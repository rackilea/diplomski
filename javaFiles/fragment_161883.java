String input = "<UserGroup:groupName> , <RULE: ruleName>";

Map<String, String> keyVals = Arrays.stream(input.split("\\s*,\\s*"))
                                    .filter(s -> s.contains(":"))
                                    .map(s -> s.trim())
                                    .map(s -> s.replaceAll("<|>", ""))
                                    .collect(Collectors.toMap(
                                        s -> s.split(":")[0].toLowerCase().trim(),
                                        s -> s.split(":")[1].trim()
                                    ));
String userGroup = keyVals.get("usergroup");
String rule = keyVals.get("rule");