String cypher = "MATCH (a) WHERE a.name IN {names} RETURN a";
Map<String, Object> params = new HashMap<>();
List<String> names = new ArrayList<>();
//add some names to the names list
params.put("names", names);
ExecutionResult result = engine.execute(cypher, params);