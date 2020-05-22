int row = 0, col = 0;
    String[][] india = new String[1][9];
    String mystringno2[];
    mystringno2 = mystring;
    int i = 0;
    int j = 0;
    String x = "_";
    int i1;
    do {
        i = mystringno2[j].indexOf(x, i);
        i1 = i + 1;
        i1 = mystringno2[j].indexOf(x, i1);
        if (i1 <= -1) {

            break;
        }
        i++;
        india[0][col] = mystringno2[j].substring(i, i1);
        System.out.println("dfref   " + row + "  " + col + "   " + india[row][col]);
        col++;

    } while (j < mystringno2.length);

    return india;