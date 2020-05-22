public void printDaysInMonth() {
    for (int i = 1; i <= 12; i++) {
        int m = getDaysInMonth(i);
        System.out.println("Month " + i + " has " + m  + "days.");
    }
}