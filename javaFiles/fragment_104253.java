public void ColumnNumberToLetter() {
    int inputColumnNumber = 49;
    String outputColumnName = "";
    int Base = 26;        
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";        

    int TempNumber = inputColumnNumber;
    while (TempNumber > 0) {
       int position = TempNumber % Base;
       outputColumnName = (position == 0 ? 'Z' : chars.charAt(position > 0 ? position - 1 : 0)) + outputColumnName;
       TempNumber = (TempNumber - 1) / Base;
    }
    System.out.println("ColumnNumberToLetter :" + inputColumnNumber + " = " +  outputColumnName);
}