String[] stringValues = jTextField1.getText().split(",");
//split the input "1,2,3,4" by "," result in array = ["1","2","3","4"]

int[] numArray= new int[stringValues.length];


for(int i=0; i<numArray.length; i++){
    numArray[i]= Integer.parseInt(stringValues[i]);
    //parse every string to int
}

String value ="";
for (int j = 0; j < numArray.length; j++) {
    value += numArray[j] + ",";
    //for each int in numArray ad: "numArray[j],"
}
//result is = "1,2,3,4,"

value = value.substring(0, value.length() - 1);
//remove last unused ","

jLabel1.setText( value );