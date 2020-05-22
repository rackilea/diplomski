double f = 2.0;
    int i = (int)f;
    if (i==f){
        String s = String.valueOf(new DecimalFormat("#").format(f));
        System.out.println(s);
    }
    else{
        String s = String.valueOf(new DecimalFormat("#.###").format(f)); // for example
        System.out.println(s);
    }
}

//now if the number after the point is fully zero, it will not take it