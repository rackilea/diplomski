int numOfDots = 3;
    String line = "...#.#...#";
    String[] arry = line.split("#");

    int middle = arry.length%2==0?arry.length/2:(arry.length/2 +1);

    for (int i=middle,j = middle; i >= 0; i--,j++) {
        if(arry[i].length()==numOfDots) {
            System.out.println("Result Index in arry :" + i);
            break;
        }
        if(j<arry.length&&arry[j].length()==numOfDots) {
            System.out.println("Result Index in arry :" + j);
            break;
        }
    }