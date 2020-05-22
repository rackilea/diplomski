ArrayList<ArrayList<Number>> table = new ArrayList<>();
table.add(new ArrayList<>());
table.add(new ArrayList<>());
table.get(0).add(0);
table.get(0).add(10);
table.get(1).add(20);
table.get(1).add(30);
System.out.println("Value=" + table.get(1).get(0));