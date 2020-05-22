try (BufferedReader in = new BufferedReader(new FileReader(file))) {
    Pattern p = Pattern.compile("\"(.*?)\",(-?\\d+),(-?\\d+)");
    for (String line; (line = in.readLine()) != null; ) {
        Matcher m = p.matcher(line);
        if (! m.matches())
            throw new IOException("Invalid line: " + line);
        String value1 = m.group(1);
        int value2 = Integer.parseInt(m.group(2));
        int value3 = Integer.parseInt(m.group(3));
        // use values here
    }
} catch (IOException | NumberFormatException ex) {
    ex.printStackTrace();
}