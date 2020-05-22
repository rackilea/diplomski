UnaryOperator<String> firstChangeFunction = arg -> arg.concat(" + first");
UnaryOperator<String> secondChangeFunction = arg -> arg.concat(" + second");

String firstValue = inputConverter.convertBy(
            valueToListFunction
                    .andThen(firstValueFunction)
                    .andThen(secondChangeFunction)
                    .compose(firstChangeFunction)
); // sout: fname_value + first + second