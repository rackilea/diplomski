while ((line = reader.readLine()) != null) {
    if (line.startsWith("User")) {
        user = line.substring(line.indexOf(" ") + 1);
    } else if (line.startsWith("LocalFile")) {
        String tmp = line.substring(line.indexOf(" ") + 1);
        System.out.println("Test: " + tmp);
        setLocalFile(tmp);
    }
}