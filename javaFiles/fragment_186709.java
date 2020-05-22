final static Map<String, Integer> arity = new HashMap<String, Integer>() {{
    put("*", 2);
    put("/", 2);
    put("+", 2);
    put("-", 2);
    put("neg", 1);
    put("inv", 1);
    // etc...
}};

static boolean isConstant(String token) {
    return Pattern.matches("^[0-9]+$", token);
}

static boolean valid(String postfix) {
    int availableArguments = 0;
    for(final String token: postfix.split(" +")) {
        if(isConstant(token)) {
            availableArguments += 1;
        } else if(arity.containsKey(token)) {
            final int argumentsRequired = arity.get(token);
            if(argumentsRequired > availableArguments) {
                // argument required
                return false;
            } else {
                availableArguments -= argumentsRequired;
                // not all functions must stack only one result
                availableArguments += 1;
            }
        } else {
            // wrong token
            return false;
        }
    }
    // other values than 1 could be valid
    return availableArguments == 1;
}

public static void main(String... args) {
    for(final String expr: asList("3 4 + *", "3 neg 2 + 5 * neg 4 +")) {
        System.out.printf("'%s' is %svalid%n", expr, valid(expr) ? "": "not ");
    }
}