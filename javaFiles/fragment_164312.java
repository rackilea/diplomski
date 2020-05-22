String str = "<%= user %>"; // <-- the input String
String function = "encode"; // <-- the function to add
// Create an output pattern using $1; the first match to `()` in replaceAll.
String replacement = String.format("<%%= %s($1) %%>", function);
str = str.replaceAll("<%=\\s*(\\S+)\\s*%>", replacement);
System.out.println(str);