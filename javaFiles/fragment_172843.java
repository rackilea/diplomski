Iterator<String> numbers = new BinaryPermutation("01", 3).iterator();
Iterator<String> operators = new BinaryPermutation("&|", 2).iterator();

while (numbers.hasNext()) {
    String number = numbers.next();
    while (operators.hasNext()) {
        String operator = operators.next();
        String permutation = combineString(number, operator);
        System.out.println(permutation);
    }
    operators = new BinaryPermutation("&|", 2).iterator();
}