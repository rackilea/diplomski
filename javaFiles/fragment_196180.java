Scanner scanner = new Scanner(new File("data.txt")); // or new Scanner(System.in) for reading from command line.
List<Integer> list = new ArrayList<Integer>(); 
while (scanner.hasNext()) {
    int number = scanner.nextInt();
    if (number<0||number>1018)
        break;
    list.add(number);
}
scanner.close();
System.out.println(list);