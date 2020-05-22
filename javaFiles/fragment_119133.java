while ((temp = preader.read()) != -1) {
    int flag = 0;  // moved this to inside the loop
    for (int i = 2; i * i < temp; i++) {
        if (temp % i == 0) {
            flag = 1;
            break;
        }
    }
    Thread.sleep(100);
    if (flag == 0) System.out.println(temp);
}