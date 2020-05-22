int[] arr = new int[4];

// You only need to create it once.
Scanner sc = new Scanner(System.in);
for (int i = 0; i < 4; i++) {
    arr[i] = sc.nextInt();
}

// When input is finished, output contents.
for (int i = 0; i < 4; i++) {
    System.out.println(arr[i] + "-" + (char) arr[i]);
}