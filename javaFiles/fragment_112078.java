for (int j = 0; j < fileList.size(); j++) {
    String csvFile = readPath + fileList.get(j);
    System.out.println("Read:  " + csvFile);
    reader = new CSVReader(new FileReader(csvFile), ';');
    hugeList = reader.readAll();

    String[] data = new String[1];
    for (int m = 0; m < hugeList.size(); m++) {
        String[] values = hugeList.get(m);
        data[0] = values[0];
        writer.writeNext(data);
    }
}