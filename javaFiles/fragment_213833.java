int biggest = 1;
for (int start = 100; start < 1000; start++) {
    for (int start2 = 100; start2 < 1000; start2++) {
        int temp = start * start2;  

        String strTemp = temp + "";     

        if (strTemp.equals(new StringBuilder(strTemp).reverse().toString())) {
            if (temp > biggest) {
                biggest = temp;
                System.out.println("Original: " + strTemp);
                System.out.println("Reverse: " + new StringBuilder(strTemp).reverse().toString());
                System.out.println("Siffra: " + start);
                System.out.println("Siffra2: " + start2);
            }

        }       
    }