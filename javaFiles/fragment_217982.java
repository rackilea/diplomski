int count = 0;

int brackets = 0;
for (char c : str.toCharArray()) {  // str is the string you are searching
    if (c == '[') {
        if (brackets == 0) {
            count++;
        }
        brackets++;
    }
    else if (c == ']') {
        brackets--;
    }
}