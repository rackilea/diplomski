int[] info = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
for (int i : info) {
    if (i % 10 == 0)
        System.out.println(i);
    else
        System.out.println(i + ", ");
}