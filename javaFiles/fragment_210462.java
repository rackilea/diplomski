int octal = 037;

    System.out.println(octalToHexString(octal));

    int octal = 037;

    System.out.println(octalToHexString(octal));

}

public static String octalToHexString(int octal) {

    final  char[] hex = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'A' , 'B' ,
            'C' , 'D' , 'E' , 'F'
    };


    int val = octal;
    int radix = 0;
    int mask = 0;

    StringBuilder builder = new StringBuilder("0x");

    if (val==0) {
        return "0x" + 0;
    }

    while (val != 0) {

        radix = 1 << 4;
        mask = radix - 1;
        builder.insert(2, hex[val & mask]);
        val >>>= 4;
    }

    return builder.toString();

}