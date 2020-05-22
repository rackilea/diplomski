map (LongWritable inputKey, Text inputValue){ //assuming value is stored as Text
    String[] columns = inputValue.get().split(",");
    if (columns.length != 8) return; //or throw IllegalArgumentException
    C1 = columns[6];
    if (C1.equals("A") || C1.equals("B") || C1.equals("C")) {
        emit (inputKey, inputValue); //assuming that you just need to keep the records which meet your criteria
    }
}