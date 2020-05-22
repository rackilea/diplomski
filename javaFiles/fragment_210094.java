Double total = 0;
    for(int i=0; i < Years; i++) {
        total += MoneySaved;
        total *= 1.05;
    }
    System.out.println(total);