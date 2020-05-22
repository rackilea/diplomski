for(int i = 0; i < randomSquare.length; i++) {
        // the letter at the beginning of the row
        System.out.print(randomSquare[i] + "  ");

        // the Grid contents for that line
        int index = 0;
        for(int j = 0; j < randomSquare.length; j++) {

            if(ran.nextBoolean()){
            if (A >= 65 && A <= 90){

                index = A + ran.nextInt(Z - A);
            }
            }else
            if (num9 <= 57 && num9 >= 48) {

                index = num0 + ran.nextInt(num9 - num0);
            }
            System.out.print("" + (char)index);
        }
        System.out.println();
        index++;    }

    for(int i = 0; i < randomSquare.length; i++) {
        // the letter at the beginning of the row
        System.out.print(randomSquare[i] + "  ");

        // the Grid contents for that line
        int index = 0;
        for(int j = 0; j < randomSquare.length; j++) {

            if(ran.nextBoolean()){
            if (A >= 65 && A <= 90){

                index = A + ran.nextInt(Z - A);
            }
            }else
            if (num9 <= 57 && num9 >= 48) {

                index = num0 + ran.nextInt(num9 - num0);
            }
            System.out.print("" + (char)index);
        }
        System.out.println()

;
        index++;    }