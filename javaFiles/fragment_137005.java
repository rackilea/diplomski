for (int i = 0; i < up.length; i++) {
    int days = 1;
    for (int distance = up[i]; distance < Top[i]; distance += up[i] - down[i]) {
        days++;
    }
    System.out.println(days);
}