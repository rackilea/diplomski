ArrayList list = new ArrayList();

Scanner s = new Scanner(System.in);

while (s.hasNext()) {
    String command = s.next();
    char ch = command.charAt(0);
    switch (command) {
        case "c":
            list.clear();
            return;
        case "a":
            ch = s.next().charAt(0); // no more error
            list.add(ch);
            break;
        case "e":
            // this will print all of the array just for testing purposes
            System.out.println(list.toString());
            break;
    }
}