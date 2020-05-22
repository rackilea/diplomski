for(double a = 1; a <= num; a++)      {
        double quo = num/a;
        int iquo  = (int)quo;
        if( iquo == quo ){
           System.out.println(iquo);
        } else {
           System.out.println(quo);
        }
    }