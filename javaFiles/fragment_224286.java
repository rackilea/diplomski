String str = "-123";
    int numbers[] = null;
    int characterIndex = 0;
    boolean isNegative = false;

    if (str.trim().startsWith("-")) {
        characterIndex = 1;
        isNegative = true;
        numbers = new int[str.length() - 1];
    } else {
        numbers = new int[str.length()];

    }

    for (int numIndex = 0; characterIndex < str.length(); characterIndex++, numIndex++) {
        numbers[numIndex] = Integer.parseInt(str.substring(characterIndex, characterIndex + 1));
        if (isNegative) {
            numbers[numIndex] = -1 * numbers[numIndex];
        }

    }
    System.out.println(Arrays.toString(numbers));