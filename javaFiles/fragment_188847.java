StringBuilder resultBuilder = new StringBuilder();

for (int i = 1; i < w.length(); i++) { //Note: Starting at index 1
    if (Character.isUpperCase(w.charAt(i))) {
        resultBuilder.append(" ")
                .append(w.charAt(i));
    } else {
        resultBuilder.append(w.charAt(i));
    }
}
System.out.println(resultBuilder.toString());