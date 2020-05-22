public static void main(String[] args) {
    int random[] = random3();
    int a = random[0];
    int b = random[1];
    int c = random[2];
    System.out.println("Der durch den Median berechnete Medianwert ist: " 
                        + median(a, b, c));

    random[] = random3();
    a = random[0];
    b = random[1];
    c = random[2];
    System.out.println("Der durch den Median2 berechnete Medianwert ist: "
                        + median2(a, b, c));

}