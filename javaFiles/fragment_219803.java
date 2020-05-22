String string = "[apple, peach, plum]";
System.out.println(
    // Array String representation
    Arrays.toString(
        // removing square brackets
        string.substring(1, string.length() - 1)
        // splitting by comma + optional whitespace
        .split(",\\s*")
    )
);