Map<String, IntBinaryOperator> operations = new HashMap<>();
operations.put("add", Integer::sum);
operations.put("subtract", (a, b) -> a - b);
operations.put("multiply", (a, b) -> a * b);
//...
System.out.println(operations.get("multiply").applyAsInt(10, 20));