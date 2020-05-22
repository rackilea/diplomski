String SEPARATOR = "";
for(i = 0; i < n; i++) {
    data[i] = input.nextInt();
}
for(i = 0; i < n; i++) {
    if((i + 1) % 2 == 0) {
        System.out.print(SEPARATOR + data[i]);
        sum += data[i];
        SEPARATOR = ",";
    }
}