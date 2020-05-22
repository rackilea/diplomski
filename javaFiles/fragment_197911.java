String aDataRow = "";
StringBuilder buffer = new StringBuilder();

while ((aDataRow = myReader.readLine()) != null) {
    buffer.append(aDataRow);
    buffer.append("\n");
}
aDataRow = buffer.toString();