int flagOffset = 0x1F1E6;
int asciiOffset = 0x41;

String country = "US";

int firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset;
int secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset;

String flag = new String(Character.toChars(firstChar))
            + new String(Character.toChars(secondChar));