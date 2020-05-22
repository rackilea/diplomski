private ArrayList<Integer> calcOperator = new ArrayList<Integer>();
private ArrayList<Character> calcOperand = new ArrayList<Character>();

public void parseInput(){
    int start = 0;
    int end = 0;
    for (int i = 0; i < input.length(); i ++){
        if (input.charAt(i) == '+'){
            end = i;
            String operator = input.substring(start, end).trim();
            int opAsInt = Integer.parseInt(operator);
            char operand = '+'; //as defined in the if-clause

            calcOperator.add(opAsInt);
            calcOperand.add(operand);

            //set index
            start = i + 1;
        }           
    }
    //last operatore would be missing right now, so add it!
    String operator = input.substring(start, input.length() ).trim();
    int opAsInt = Integer.parseInt(operator);
    calcOperator.add(opAsInt);
}