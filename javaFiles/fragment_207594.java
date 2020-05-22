for(int j=0; j<array.length; j+=4) {

            b = array[i];
            array[i] = array[i+3];
            array[i+3] = b;


            b = array[i+1];
            array[i+1] = array[i+2];
            array[i+2] = b;
        }