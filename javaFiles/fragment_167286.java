final String possibleValues = "abcd";
    final List<Integer> indices = new LinkedList<>();
    for (int i = 0; i < possibleValues.length(); i++) {
        indices.add(i);
    }
    Collections.shuffle(indices);

    final char[] baseChars = possibleValues.toCharArray();
    final char[] randomChars = new char[baseChars.length];
    for (int i = 0; i < indices.size(); i++) {
        randomChars[indices.get(i)] = baseChars[i];
    }
    final String randomizedString = new String(randomChars);
    System.out.println(randomizedString);

    final Random random = new Random();
    final int firstStrLength = random.nextInt(randomChars.length);
    final int secondStrLength = randomChars.length - firstStrLength;
    final String s1 = randomizedString.substring(0, firstStrLength);
    final String s2 = randomizedString.substring(firstStrLength);

    System.out.println(s1);
    System.out.println(s2);