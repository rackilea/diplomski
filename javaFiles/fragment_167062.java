while (numTwo > numOne) {

        if (line%11==0){
            System.out.println("");
        }

        if ((numOne % 5 == 0) && (numOne % 6 != 0)) {
            System.out.print(numOne + " ");
            line++;
        }
        if ((numOne % 6 == 0) && (numOne % 5 != 0)) {
            System.out.print(numOne + " ");
            line++;
        }
      numOne++;
    }