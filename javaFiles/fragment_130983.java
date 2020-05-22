while ((line = input.readLine()) != null) {
    if (line.trim().length() == 5) {
        output.write(line);
        output.newLine();
    }
}