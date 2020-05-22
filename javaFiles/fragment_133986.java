while (scan.hasNext()) {
    String input = scan.nextLine();
    if (input.trim().equals("exit")) {
        // Putting 'exit' amongst the echo --EOF--s below doesn't work.
        writer.write("exit\n");
    } else {
        writer.write("((" + input + ") && echo --EOF--) || echo --EOF--\n");
    }
    writer.flush();

    line = reader.readLine();
    while (line != null && ! line.trim().equals("--EOF--")) {
        System.out.println ("Stdout: " + line);
        line = reader.readLine();
    }
    if (line == null) {
        break;
    }
}