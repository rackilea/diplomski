Map<String, FileWriter> fileMap = new HashMap<String, FileWriter>();

while ((line = br.readLine()) != null) {
    if (!line.contains("-9999")) {
        if (m.find()) {
            stateFileName = m.group(1); 
            stateFileName = "States/" + stateFileName + ".csv";
            FileWriter stateFileWriter = fileMap.get(stateFileName);
            if (stateFileWriter == null) {
                stateFileWriter = new FileWriter(stateFileName, true);
                fileMap.put(stateFileName, stateFileWriter);
            }

            stateFileWriter.write(line + "\n");
        }
    }
}

// flush the writers and close once you have parsed the entire file
for(Map.Entry<String, FileWriter> entry : fileMap.entrySet()) {
    FileWriter writer = entry.getValue();
    writer.flush();
    writer.close();
}