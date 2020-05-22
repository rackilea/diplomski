ArrayList<String> list = new ArrayList<>();
System.out.println(getCap(list));   // Prints 0

list.add("");
System.out.println(getCap(list));   // Prints 10

for (int i = 1; i < 11; i++)
    list.add("");
System.out.println(getCap(list));   // Prints 15

for (int i = 11; i < 16; i++)
    list.add("");
System.out.println(getCap(list));   // Prints 22