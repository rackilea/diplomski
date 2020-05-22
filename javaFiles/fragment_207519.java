Scanner s = new Scanner(System.in);
ArrayList<String> list = new ArrayList<>();
while (s.hasNextLine()) {
    list.add(s.nextLine());
}

System.out.println(list);