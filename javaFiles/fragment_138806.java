public static void writeFile(File file, String index) {
    if (file.exists()) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line; (line = in.readLine()) != null; )
                if (line.equals(index))
                    return;
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + file, e);
        }
    }
    try (FileWriter out = new FileWriter(file, true)) {
        out.write(index);
        out.write(System.lineSeparator());
    } catch (Exception e) {
        throw new RuntimeException("Error appending to file: " + file, e);
    }
}