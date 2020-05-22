difficulty = 1 + rand.nextInt(diff);
boolean win = false;
switch(choice) {
    case 1:
        while(win != true) {
            System.out.println(difficulty);
            System.out.println("Tries: " + tries);