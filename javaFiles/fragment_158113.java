List<Integer> list = new ArrayList<>();
Scanner scanner = new Scanner(new FileInputStream(nameFile))
   .useDelimiter("\\D+");
while (scanner.hasNext()) {
    int i = scanner.nextInt();
    list.add(i);
}