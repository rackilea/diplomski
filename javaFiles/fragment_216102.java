List<String> lines = new ArrayList<String>();

try (BufferedReader br = new BufferedReader(new FileReader(file))) { //opening the file
    String line;
    while ((line = br.readLine()) != null) { 
       // process the line.
       lines.append(line);
    }
}

String lastLine = lines.remove(lines.size() - 1); 
lastLineTokens = lastLine.split(" ");

String result = String.parseInt(lastLineTokens.get(0)) + " " lastLineTokens.get(1);
lines.append(result); //here's the modified list