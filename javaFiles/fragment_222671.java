int level = 1;  
Scanner reader = new Scanner(System.in);
String selection = null;

while (true) {
    if (data.done) {
        level--;
    }

    data.done = false;
    System.out.println(getSubmenu(level, data));

    if (level <6) {
        selection = reader.nextLine();
    } else {
        level = 4;
    }

    if (validSelection(selection)) {
        level = getLevel(level, selection);
        data = getData(level, data, selection);
    } else {
        System.out.println("Invalid entry");
    }

    if (data == null) {
        System.out.println("Level "+ level + "selection " + selection);
        break; // exit command was typed
    }
}
reader.close();