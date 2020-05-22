while (input.hasNext)) {
    int times = input.nextInt();
    String word = input.next();
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= times; i++) {  
       builder.append(word);
    }  
    System.out.println(builder.toString());
 }