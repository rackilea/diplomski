while (scanner.hasNextLine()) {  // Check whether you have nextLine to read

    String str = scanner.nextLine(); // Read the nextLine

    if (str.equals("stop")) {  // If line is "stop" break
        break;
    }

    String[] tokens = str.split(" ", 1);  // Split your string with limit 1
                                          // This will give you 2 length array

    int firstValue = Integer.parseInt(tokens[0]);  // Get 1st integer value
    String secondString = tokens[1];  // Get next string after integer value
}