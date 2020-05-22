String line = "id:1234   alert:a-b   up:12.3 down:12.3";
// first split the line by whitespace
String[] keyValues = line.split("\\s+");

for (String keyValueString : keyValues) {
    String[] keyValue = keyValueString.split(":");
    // TODO might want to check for bad data, that we have 2 values
    System.out.println(String.format("Key: %-10s Value: %-10s", keyValue[0], keyValue[1]));
}