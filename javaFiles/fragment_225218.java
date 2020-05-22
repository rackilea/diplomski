Map<String, List<String>> fileLines = new HashMap<String, List<String>>();
for (String file : FileArray.filearray)
    BufferedReader reader = new BufferedReader(new FileReader(fileext));

    List<String> lines = new ArrayList<String>();
    while ((line = reader.readLine()) != null){
        lines.add(line);
    }

    fileLines.put(file, lines);
}