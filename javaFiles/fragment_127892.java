outerloop:
for (int count = 0; count < arrayone.length; count++) {
    for (int count2 = 0; count2 < arrayone[count].length; count2++) {
        loop++;    //assume first check counts as one loop
        if (arrayone[count][count2] == input[id][x]) {
            break outerloop;
        }
    }
}