String male = "maleg*$m-z";
    String female= "femal^\\$e-is";
    String deletedMale = male.replaceAll("["+Pattern.quote(female)+"]", "");
    String deletedFemale = female.replaceAll("["+Pattern.quote(male)+"]", "");
    System.out.println(deletedMale);
    System.out.println(deletedFemale);