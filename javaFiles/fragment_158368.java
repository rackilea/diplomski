Scanner scanner = new Scanner(System.in);
    String[] arrayList = new String[25];
    String input;
    int i = 0;

    for (input = scanner.nextLine(); (!input.isEmpty() && i < 25); input = scanner.nextLine()) {
        arrayList[i] = input;
        i++;
    }

    String[] newArrayList = new String[i];

    int index = 0;
    for (String element : arrayList) {
        if (element == null)
            continue;
        newArrayList[index] = element;
        index++;
    }