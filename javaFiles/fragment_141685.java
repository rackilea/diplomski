public double calcResult(ArrayList<String> aL) {
    if (aL.isEmpty()) { //Break condition
        return -1; //Or whatever you like to show an error
    } else {
        double tempNum = Double.parseDouble(aL.get(0));
        aL.remove(0);

        if (!aL.isEmpty()) { //Break condition
            String operator = aL.get(0);
            aL.remove(0);

            if (operator.equals("+"))
                return tempNum + calcResult(aL);
            if (operator.equals("*"))
                return tempNum * calcResult(aL);
            if (operator.equals("-"))
                return tempNum - calcResult(aL);
            if (operator.equals("/"))
                return tempNum / calcResult(aL);

            return tempNum;
        }else{
            return tempNum;
        }
    }
}