String response = "Response: <section><title>..."
Pattern pattern = Pattern.compile("Result.+?>([^<]+?)<");
Matcher match = pattern.matcher(response);
String clean = "";
if (match.find())
    clean = match.group(1);
System.out.println(clean);