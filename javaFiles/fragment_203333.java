double a=Double.parseDouble("1.8")/100;
      DecimalFormat df=new DecimalFormat("0.000");
      String f = df.format(a); 
      try {
        double dblValue = (Double)df.parse(f) ;
        System.out.println(dblValue);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }