String[] vowelArray = arrayInput;
for (int x = 0; x < vowelArray.length; x++) {
    char[] chars = vowelArray[x].toCharArray();
    for (int a = 0; a < chars.length; a++) {
        switch (chars[a]) {
            case 'A': chars[a] = "_"; break;
            case 'a': chars[a] = "_"; break;
            case 'E': chars[a] = "_"; break;
            case 'e': chars[a] = "_"; break;
            case 'I': chars[a] = "_"; break;
            case 'i': chars[a] = "_"; break;
            case 'O': chars[a] = "_"; break;
            case 'o': chars[a] = "_"; break;
            case 'U': chars[a] = "_"; break;
            case 'u': chars[a] = "_"; break;
            case 'Y': chars[a] = "_"; break;
            case 'y': chars[a] = "_"; break;
        }
    }
    vowelArray[x] = new String(chars);
}