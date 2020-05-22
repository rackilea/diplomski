String st = text.getText();
//Example: String st = "2 + 3";
//remove white space
st = st.replaceAll("\\s","");
//might have to change to allow for negative numbers
String[] splitStrings = (st.split("((?<=[+-/*])|(?=[+-/*]))")); 
//Example: splitStrings is now -> ["2","+","3"]