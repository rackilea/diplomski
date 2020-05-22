String[] tokens = s.split("\n");
StringBuilder resultBuilder = new StringBuilder();
Set<String> alreadyPresent = new HashSet<String>();

boolean first = true;
for(String token : tokens) {

    if(!alreadyPresent.contains(token)) {
        if(first) first = false;
        else resultBuilder.append("\n");

        if(!alreadyPresent.contains(token))
            resultBuilder.append(token);
    }

    alreadyPresent.add(token);
}
String result = resultBuilder.toString();