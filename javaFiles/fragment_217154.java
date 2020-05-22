for (int i = 0; i < array.length; i++) {

        if (array[i]==ch1){

            return i;

        }
    }
    return  -1;
}


public int getLastLocation(char ch2){


    for (int i = array.length-1; i>=0; i--) {

        if (array[i]==ch2){

            return i;

        }
    }

    return  -1;
}


        for (int i = ch.length-1; i>=0; i--) {

            if (ch[i]==chart){

                return i;

            }
        }

        return  -1;
    }