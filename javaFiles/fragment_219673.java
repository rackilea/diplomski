void play() {
    for (int i = 0; i < 10; i++) {
        System.out.println("Geef de letter die je wilt raden: ");
        guess = sc.nextLine().toUpperCase().charAt(0);
        boolean hit = false;
        for (int ii = 0; ii < randW.length(); ii++) {
            if (guess == randW.charAt(ii)) {
                hiddenW.setCharAt(ii, guess);
                hit = true;
            }
        }
        if (hit) {
            System.out.println(hiddenW);
            System.out.println("Aantal fouten: " + wrongG);
        }
    }
}