public static void calculation() {

    switch(i)
    {
        double result = 0;
        case 1: 
            result = n1+n2;
            et3.setText(String.valueOf(result));
        break;

        case 2: 
            result = n1-n2;
            et3.setText(String.valueOf(result));
        break;

        case 3: 
            result = n1*n2;
            et3.setText(String.valueOf(result));
        break;

        case 4: 
            result = n1/n2;
            et3.setText(String.valueOf(result));
        break;
    }
}