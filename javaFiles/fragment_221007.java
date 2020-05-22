String[] strArray = new String[st.countTokens()]; // Create an array with no. of tokens as the size
int counter = 0; // Counter variable to be used as the arrays index.
while (st.hasMoreElements()){
    //instead of printing the element I want to generate str[i] or something of the sort
    strArray[counter++] = st.nextElement(); // add the element to the array
}