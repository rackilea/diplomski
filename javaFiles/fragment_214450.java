for (int i=0;i<evolution.size()-1; i++)
    {
        double i1 =evolution.get(i+1) ;
        double i0 = evolution.get(i) ;
        if (i1/i0>0)
        {
            //you are good 
            sommeTendance+= Math.log(i1/i0);
            sommeVarianceQuotidienne += Math.pow(Math.log(i1/i0),2);
        }
        else
        {
            //you are not good, the number will yield an undefined result 
            //do something else... like displaying an error....?
            System.out.println("Math.log will yield into an undefined result. Please check your input");
        }
    }