Map<String, Runnable> functions = new HashMap<>();
functions.put("senior_heavy") = this::function1;
functions.put("senior_medium") = this::function2;
functions.put("senior_light") = this::function3;
functions.put("middleaged_heavy") = this::function4;
...
functions.put("child_light") = this::function9;