float f=  24.56f;//Replace with your float number
    int i = (int)f;
    if(i<100)
        System.out.println(new DecimalFormat("#.##").format(f));//This functions will round the last bits also i.e. greater then 4 will increase the number preceding also 
    else if( i < 1000)
        System.out.println(new DecimalFormat("#.#").format(f));
    else 
        System.out.println(new DecimalFormat("#").format(f));