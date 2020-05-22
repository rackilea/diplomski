for (int i = 0; i<line.length(); i++){
    if (!isDelimiter(lineCharArray[i]) && !isOperator(lineCharArray[i]) && flag==false){
        //System.out.println(lineCharArray[i]);
        temp += lineCharArray[i];
    } else {
        array.add(temp);
        // Resetting temp variable.
        temp = "";
        if (isDelimiter(lineCharArray[i])) {
            array.add( String.valueOf(lineCharArray[i]));
        }
        if (isOperator(lineCharArray[i])) {
            array.add( String.valueOf(lineCharArray[i]));
        }
    }
}
// Adding last temp to the array.
array.add(temp);