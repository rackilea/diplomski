int colLastName, colFirstName, colAddress;
line = bReader.readLine();
String columnOrder []= line.split("\t");
for (int i=0; i< columnOrder.length; i++){
if (columnOrder[i].equals("lastName")){
  colLastName = i;
}
else if (columnOrder[i].equals("firstName"){
  colFirstName = i;
}
else if (columnOrder[i].equals("address"){
  colAddress = i;
}
}


    while ((line = bReader.readLine()) != null) {
        lineNumber++;
        String datavalue[] = line.split("\t");
        String lastName = datavalue[colLastName];
        String firstName = datavalue[colFirstName];
        String address = datavalue[colAddress];

        System.out.println(lastName + "'" + firstName + "," + address);

    }