// locations of top-level operators:
List<Integer> locations = new ArrayList<Integer>();

int level = 0;

for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);

    if (c == '(') {
        level++;
    }
    else if (c == ')') {
        level--;
    } 
    else if ("+-*/".indexOf(c) >= 0 && level == 1) {
        locations.add(i);
    }
}