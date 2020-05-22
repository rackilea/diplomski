Integer rangeNo[] = new Integer[10];
    String line = "[2,9], [3,11]";
    line = line.replace('[', ' ');
    line = line.replace(']', ' ');
    String[] parts = line.split(",");

    for (int i = 0; i < parts.length; i++) {
        rangeNo[i] = Integer.parseInt(parts[i].trim());
        System.out.println("{" + rangeNo[i] + "}");
    }