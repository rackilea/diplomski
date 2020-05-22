final String fname = "fname_value"

InputConverter<String> inputConverter = new InputConverter<>(fname);

Function<String, List<String>> valueToListFunction = Arrays::asList;
Function<List<String>, String> firstValueFunction = l -> l.get(0);

List<String> strings = inputConverter.convertBy(valueToListFunction);//[fname_value]
String firstValue = inputConverter.convertBy(
            valueToListFunction
                    .andThen(firstValueFunction)
);