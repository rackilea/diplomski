public static LinkedList Of(String[] input) {
        if (input == null || input.length < 1)
            return null;
        return LinkedList.Of(input, input.length - 1);
    }

    public static LinkedList Of(String[] input, int i) {
        if (i > 0)
            return new LinkedList(input[i], LinkedList.Of(input, i - 1));
        return new LinkedList(input[i], null);
    }