for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));

    if( (i + 1)%10 == 0){ //add one to not trigger this on the first iteration
        System.out.println("####");
    }
}