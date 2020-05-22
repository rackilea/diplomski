List<Integer> s = new ArrayList<Integer>();
while (true) {
    printf("Enter Number or -1 to finish.%n");
    int num = sc.nextInt();
    if (num < 0) break;
    s.add(Integer.valueOf(num));
 }