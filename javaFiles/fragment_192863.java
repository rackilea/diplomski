final int TEXTFIELDS_COUNT = 5; 
// Create an array of 5 JTextFields
JTextField[] fields = new JTextField[TEXTFIELDS_COUNT];

for(int count = 0; count< TEXTFIELDS_COUNT; count++){
    // fields[count] represents a single JTextField
    fields[count] = new JTextField();

    // Do something with fields[count], like setting its text 
    // fields[count].setText("some text");

    StoreValueFromTable[count] = "QueryTechnica"+count;
    ColumName[count] = "QT"+count;
    System.out.println(StoreValueFromTable[count]+", "+ColumName[count]);
}