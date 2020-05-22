String StringResultOfEquation;

public void generate(View view) {
    Random random = new Random();
    int numOfOperations = random.nextInt(2) + 1;

    List<String> operations = new ArrayList<>();

    for (int i = 0; i < numOfOperations; i++) {
        String operation = operationSet[random.nextInt(4)];
        operations.add(operation);
    }

    int numOfNumbers = numOfOperations + 1;
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < numOfNumbers; i++) {
        int number = random.nextInt(10) + 1;
        numbers.add(number);
    }

    String equation = "";
    for (int i = 0; i < numOfOperations; i++) {
        equation += numbers.get(i);
        equation += operations.get(i);
    }
    equation += numbers.get(numbers.size() - 1);

    TextView TextEquation = (TextView) findViewById(R.id.textView);
    TextEquation.setText(equation);

    StringResultOfEquation = String.valueOf(equation);

}