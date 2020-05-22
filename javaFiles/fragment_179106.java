String str = "one, two, three, four";
    int lastIndex = 0;
    int firstIndex=0;
    while (lastIndex != -1) {

        lastIndex = str.indexOf(',', lastIndex);

        if (lastIndex != -1) {
            System.out.print(str.substring(firstIndex, lastIndex));

            if(lastIndex==str.lastIndexOf(',')){
            System.out.print(str.substring(lastIndex));
            }
            lastIndex += 1;
        }

        firstIndex=lastIndex;
    }
    System.out.println();