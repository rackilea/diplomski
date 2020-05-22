else if(j.compareTo(" ") == 0){
    try{
    double newOperand = new Double(temp);
    temp = "";
    System.out.println("Pushing to stack: " + newOperand);
    calcStack.push(newOperand);
    }catch(NumberFormatException ex){
        //skip
    }
}