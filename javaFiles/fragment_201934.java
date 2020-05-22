String input = "hello world ja123va456789";
String[] parts = input.split("(\\s+|(?:(?<=[A-Za-z])(?=[0-9])|(?<=[0-9])(?=[A-Za-z])))");
StringBuilder output = new StringBuilder("");
for (int i=0; i < parts.length; ++i) {
    if (i > 0) {
        output.append(" ");
    }
    output.append(parts[i]);
}

System.out.println(output);

hello world ja 123 va 456789