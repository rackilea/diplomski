// your snippet:    
pattern = Pattern.compile(regex);
matcher = pattern.matcher(docToProcess);
while (matcher.find()) {
    start = matcher.start();
    end = matcher.end();
    match = docToProcess.substring(start, end);
    String rep = createRef(match);
    stringBuilder.replace(start, end, rep);
    docToProcess = stringBuilder.toString();
    // my addition:
    System.out.println("Found:         '" + matcher.group() + "'");
    System.out.println("Replacing with: '" + rep + "'");
    System.out.println(" --> " + docToProcess);
    matcher = pattern.matcher(docToProcess);
}