String input = "-22x-77y+z=-88-10+33z-q";
input = input.replaceAll(" ", "")             // remove whitespace
             .replaceAll("=-", "-");          // remove equals sign
             .replaceAll("(?<!^)-", "+-");    // replace - with +-, except at start of line
// input = -22x+-77y+z+-88+-10+33z+-

String[] termRaw = bozo.split("[\\+*/=]");
// termRaw contains [-22x, -77y, z, -88, -10, 33z, -]

ArrayList<Integer> constants = new ArrayList<Integer>();
// after splitting,
// termRaw contains [-22, -77, '', -88, -10, 33, '-']
for (int k=0 ; k < termRaw.length ; k++) {
    termRaw[k] = termRaw[k].replaceAll("[a-zA-Z]", "");
    if (termRaw[k].equals("")) {
        constants.add(1);
    }
    else if (termRaw[k].equals("-")) {
        constants.add(-1);
    }
    else {
        constants.add(Integer.parseInt(termRaw[k]));
    }
}