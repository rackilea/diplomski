int count = 0;
    for (String s : stringList  ){
        if(s.equals("Morning")){  //s.equalsIgnoreCase(Morning) or s.contains("Morning")
            count++;
        }
    }
    System.out.println("count = "+count);