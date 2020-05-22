Map<String, String> data = new HashMap<>();
data.put("Acct1", "Y");
data.put("Acct2", "N");
data.put("Acct3", "Y");
data.put("Acct4", "N");

Expr expr = parse(tokenize("Acct1 = 'Y' AND (Acct2 = 'Y' OR Acct3 = 'Y')"));
System.out.println(expr.evaluate(data)); // true
expr = parse(tokenize("Acct1 = 'N' OR 'Y' = Acct2 AND Acct3 = 'Y'"));
System.out.println(expr.evaluate(data)); // false