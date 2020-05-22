String company1 = prop.getProperty("startDate");
    // suppose that compan1 has the value 2014-05-21

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date result =  df.parse(company1);  
    System.out.println(result);