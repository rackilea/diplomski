do {
    try {
        String input = br.readLine();
        grades = Integer.parseInt(input);
        format = true; // Add this line
    }
    catch(...) { ... } 
    if (grades > 100 || grades < 100) {
        System.out.println("Please enter within the range (0-100)");
        format = false;
    }

} while (!format);