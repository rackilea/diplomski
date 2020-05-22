String text = "My test string with year 1996 and 2015 and 1999, and 1900-2000";
    text = text.replaceAll("[^0-9]", "#"); //simple solution for replacing all non digits. 
    String[] arr = text.split("#");

    boolean hasYear = false;
    int matches = 0;
    StringBuilder values = new StringBuilder();

    for(String s : arr){
        if(s.matches("^[0-9]{4}$")){
            hasYear = true;
            matches++;
            values.append(s+" ");
        }
    }
    System.out.println("hasYear: " + hasYear);
    System.out.println("number of times: " + matches);
    System.out.println("values: " + values.toString().trim());