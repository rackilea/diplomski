String input = "getrange(1,12)";
String[] parts = input.split("\\(");
System.out.println("Command: " + parts[0]);
String[] argsParts = parts[1].substring(0, parts[1].indexOf(")")).split(",");
int arg1 = Integer.parseInt(argsParts[0].trim());
int arg2 = Integer.parseInt(argsParts[1].trim());        
System.out.println("Args: " + arg1 + ", " + arg2);