public boolean parseInput(char character,int position){ //The parseInput method splits the input of the user and puts operands in calcOperands list and operators in calcOperators list

    if ((character == '+' || character == '-' || character == '*' || character == '/'|| character == '=' )) { //If there is a character that is equal to one of the operators, add it to the calcOperators list
        if (position !=0 ){
            calcOperators.add(character);
            System.out.println(calcOperators);
            System.out.println(character);
            string = string.substring(0, position) + " " + string.substring(position+1); //The new input now contains the operands, the operators are being removed
        }
        return true; //Return true if the character is an operator
    }
    return false; //If the character is not an operator, return false
}