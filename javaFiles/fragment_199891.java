public static void main(String args[]) throws IOException {
String[] employeeDetails;

try (CSVWriter csvWriter = new CSVWriter(new FileWriter("D:\\sample\\myfile.csv", true));
    CSVReader csvReader = new CSVReader(new FileReader("D:\\sample\\source.csv"));
    ) {

  while ((employeeDetails = csvReader.readNext()) != null) {

    System.out.println(Arrays.toString(employeeDetails));
    csvWriter.writeNext(employeeDetails);
  }
}
catch (Exception ee) {
  ee.printStackTrace(); //perhaps you should also log the error?
}
}