String keyRegex = " (AND|OR|NOT|IN|ANY|KEYWORD|NONE) ";
String[] input = { "flu", "virus", "AND", "ebola" };

String joined = String.join(" ", input); //added in 1.8, use StringBuilder in earlier versions
String replaced = joined.replaceAll(keyRegex, "\n$1\n");
String[] output = replaced.split("\n");

System.out.println(Arrays.toString(output));
// [flu virus, AND, ebola]