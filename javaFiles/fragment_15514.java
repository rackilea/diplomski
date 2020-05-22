System.out.print("> ");
    input = scanner.nextLine().toLowerCase();

    for (Map.Entry<String, String[]> entry : synonymMap.entrySet()) {
        String key = entry.getKey();
        String[] value = entry.getValue();
        if (input.contains(key) || key.contains(input)) {
            System.out.println("Input found in database -> " +Arrays.asList(value));
            break;
        }
    }