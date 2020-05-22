Set<String> tokens = new HashSet<String>(Arrays.asList(s.split("\n")));
StringBuilder resultBuilder = new StringBuilder();

boolean first = true;
for(String token : tokens) {
    if(first) first = false;
    else resultBuilder.append("\n")

    resultBuilder.append(token);
}

String result = resultBuilder.toString();