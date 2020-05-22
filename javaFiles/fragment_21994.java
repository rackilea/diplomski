// location of top-level operators:
Map<OperatorData, Integer> operators = new HashMap<>();

int level = 0;
int i = 0;
while (i < str.length()) {
    char c = str.charAt(i);

    if (c == '(') {
        level++;
    } else if (c == ')') {
        level--;
    } else if (isOperatorChar(c)) {
        final int index = i;
        StringBuilder token = new StringBuilder();
        token.append(c);

        while (isOperatorChar(c = str.charAt(i + 1))) {
            token.append(c);
            i++;
        }

        operators.put(new OperatorData(token.toString(), level), index);
    }

    i++;
}

// find smallest OperatorData in map