String line = "(0, 10, 20, 'string value, 1, 2, 2', 100, 'another string', 'string, string, text', 0)";
    char splitString[] = line.toCharArray();
    List<String> foundStrings = new ArrayList<String>();
    for (int x = 0; x < splitString.length;x++){
        String found = "";
        if (Character.isDigit(splitString[x])) {
            while(Character.isDigit(splitString[x])) {
                found += Character.toString(splitString[x]);
                x++;
            }
            foundStrings.add(found);
            x --;
        }
        if (x < splitString.length) {
            int count = 0;
            int indexOfNext = 0;
            if (splitString[x] == '\'') {
                int startIndex = x + 1;
                count = startIndex;
                char currentChar = 0;
                char c = '\'';
                while(currentChar != c) {
                    currentChar = splitString[count];
                    count ++;
                    currentChar = splitString[count];
                }
                indexOfNext = count;
                for (int j = startIndex; j < indexOfNext; j++){
                    found += Character.toString(splitString[j]);
                }
                foundStrings.add(found.trim());
                x = indexOfNext;
            }
        }
    }
    for (int p = 0; p < foundStrings.size();p++) {
        if (p > 0) System.out.print(",");
        System.out.print("\"" + foundStrings.get(p) + "\"");
    }