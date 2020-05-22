String query = "MATCH (n {root:\"true\"}) return str(\"test\") as strval";
Result result = graphDb.execute(query); 
Iterator<String> strval = result.columnAs("strval");
for (String str : IteratorUtil.asIterable(strval)) {
   System.out.println(str);
}