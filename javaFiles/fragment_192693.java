do {
    String Enterproducts=in.next();
    if(Enterproducts.equals("Stop")){
        break;
    }
    int n = in.nextInt();
    for(int i=0; i<category.length; i++){
        if(Enterproducts.equals(category[i])){
            System.out.print(String.format("%-20s %s",category[i], price[i], n));
            System.out.println();
        }
    }
} while(in.hasNext());