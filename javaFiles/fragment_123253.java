List<Integer> list = new LinkedList<Integer>();
Scanner scanner = new Scanner(System.in);

while (true) {
    System.out.print("Enter a number, -1 to exit: ");
    int num = scanner.nextInt();

    if (num == -1) break;

    list.add(num);
}

// sort the list (ascending)
Collections.sort(list);

// output the list
for (Integer val : list) {
    System.out.println(val);
}