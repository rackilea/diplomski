private boolean checkRepeatCharacter(char randomCharacter,
        ArrayList<Character> passwordUsed, int usedLength,
        int maxRepeatCharacter) {
    int characterRepeated = 0;
    for (int i = 0; i < usedLength; i++) {
        if (String.valueOf(passwordUsed.get(i)).equals(
                String.valueOf(randomCharacter))) {
            characterRepeated++;
            if (characterRepeated == maxRepeatCharacter) {
                return false;
            }
        }
    }
    return true;
}

private boolean checkUsedIndex(int index, ArrayList<Integer> usedIndex) {
    for (int i = 0; i < usedIndex.size(); i++) {
        if (usedIndex.contains(index)) {
            return false;
        }
    }
    return true;
}

private int getRandomNumber(int minLength, int maxLength) {
    Random r = new Random();
    return r.nextInt(maxLength - minLength) + minLength;
}

public String generatePassword(int minLength, int maxLength,
        int maxRepeatCharacter, int minLetterAndDigit, int minLetter,
        int minLowerCaseLetter, int minUpperCaseLetter, int minDigit,
        int minSpecialCharacter, String specialCharacter) {

    final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String DIGIT = "0123456789";
    StringBuilder ALL = new StringBuilder();
    ALL.append(LOWERCASE);
    ALL.append(UPPERCASE);
    ALL.append(DIGIT);
    ALL.append(specialCharacter);
    ALL.toString();

    char getRandom;
    int length = 0;
    StringBuilder passwordGenerated = new StringBuilder();
    ArrayList<Character> characterUsed = new ArrayList<Character>();
    ArrayList<Integer> indexUsed = new ArrayList<Integer>();

    int passwordLength = 0;
    int lowerCaseLetterUsed = 0;
    int upperCaseLetterUsed = 0;
    int letterUsed = 0;
    int digitUsed = 0;
    int letterAndDigitUsed = 0;
    int specialCharacterUsed = 0;

    if (minLength > maxLength) {
        throw new IllegalArgumentException("Min. Length > Max. Length!");
    }

    if (minUpperCaseLetter + minLowerCaseLetter > minLetter) {
        throw new RuntimeException(
                "mininimum Lower Case + Minimum Uppercase cannot exceed minLetter");
    }
    if (minLetter + minDigit > minLetterAndDigit) {
        throw new RuntimeException(
                "mininimum Letter + Minimum Digit cannot exceed minimum Letter And Digit");
    }
    if (minLetter + minDigit + minSpecialCharacter > maxLength) {
        throw new RuntimeException(
                "minimum Digit + minimum Letter + Minimum Special Character cannot excced maximum Length");
    }

    while ((length < minLetter) && (length < minLetterAndDigit)) {
        length = getRandomNumber(minLength, maxLength);
    }

    while (passwordLength != length) {
        while (letterAndDigitUsed < minLetterAndDigit) {
            while (letterUsed < minLetter) {
                lowerCaseLetterUsed = 0;
                for (int i = 0; lowerCaseLetterUsed < minLowerCaseLetter; i++) {
                    int index = getRandomNumber(0, length);
                    if (checkUsedIndex(index, indexUsed) == true) {
                        getRandom = LOWERCASE.charAt(getRandomNumber(0,
                                LOWERCASE.length()));
                        if (checkRepeatCharacter(getRandom, characterUsed,
                                characterUsed.size(), maxRepeatCharacter) == true) {
                            passwordGenerated.append(getRandom);
                            characterUsed.add(getRandom);
                            indexUsed.add(index);
                            lowerCaseLetterUsed++;
                            letterUsed++;
                            letterAndDigitUsed++;
                            passwordLength++;
                            if (letterUsed == minLetter) {
                                break;
                            }
                        }
                    }
                }
                if (letterAndDigitUsed == minLetterAndDigit) {
                    break;
                }
                upperCaseLetterUsed = 0;
                for (int i = 0; upperCaseLetterUsed < minUpperCaseLetter; i++) {
                    int index = getRandomNumber(0, length);
                    if (checkUsedIndex(index, indexUsed) == true) {
                        getRandom = UPPERCASE.charAt(getRandomNumber(0,
                                UPPERCASE.length()));
                        if (checkRepeatCharacter(getRandom, characterUsed,
                                characterUsed.size(), maxRepeatCharacter) == true) {
                            passwordGenerated.append(getRandom);
                            characterUsed.add(getRandom);
                            indexUsed.add(index);
                            lowerCaseLetterUsed++;
                            letterUsed++;
                            letterAndDigitUsed++;
                            passwordLength++;
                            if (letterUsed == minLetter) {
                                break;
                            }
                        }
                    }
                }
                if (letterAndDigitUsed == minLetterAndDigit) {
                    break;
                }
            }
            for (int i = 0; digitUsed < minDigit; i++) {
                int index = getRandomNumber(0, length);
                if (checkUsedIndex(index, indexUsed) == true) {
                    getRandom = DIGIT.charAt(getRandomNumber(0,
                            DIGIT.length()));
                    if (checkRepeatCharacter(getRandom, characterUsed,
                            characterUsed.size(), maxRepeatCharacter) == true) {
                        passwordGenerated.append(getRandom);
                        characterUsed.add(getRandom);
                        indexUsed.add(index);
                        digitUsed++;
                        letterAndDigitUsed++;
                        passwordLength++;
                    }
                }
            }
        }
        for (int i = 0; specialCharacterUsed < minSpecialCharacter; i++) {
            if (checkUsedIndex(i, indexUsed) == true) {
                getRandom = specialCharacter.charAt(getRandomNumber(0,
                        specialCharacter.length()));
                if (checkRepeatCharacter(getRandom, characterUsed,
                        characterUsed.size(), maxRepeatCharacter) == true) {
                    passwordGenerated.append(getRandom);
                    characterUsed.add(getRandom);
                    indexUsed.add(i);
                    specialCharacterUsed++;
                    passwordLength++;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (checkUsedIndex(i, indexUsed) == true) {
                getRandom = ALL.charAt(getRandomNumber(0, ALL.length()));
                if (checkRepeatCharacter(getRandom, characterUsed,
                        characterUsed.size(), maxRepeatCharacter) == true) {
                    passwordGenerated.append(getRandom);
                    characterUsed.add(getRandom);
                    indexUsed.add(i);
                    passwordLength++;
                }
            }
        }
    }
    return passwordGenerated.toString();
}