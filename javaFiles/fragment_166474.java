public void removeFromBalance(String username, long amount) throws IOException {

    String tempFile = "temp.txt";
    Path oldfile = Paths.get(directory.toString(), fileName);
    File newFile = oldfile.resolveSibling(tempFile);

    Charset charset = StandardCharsets.UTF_8;
    try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(newfile, charset,
                    StandardOpenOptions.APPEND, StandardOpenOptions.CREATE));
            Files.lines(oldfile)) {
                .map(line -> line.split("\\s*,\\s*"))
                .filter(xx -> xx.length >= 2)
                .map(xx -> {
                    String userName = xx[0];
                    String balance = xx[1];
                    if (userName.equalsIgnoreCase(username)) {
                        long result = Long.parseLong(balance) - amount;
                        pw.println(userName + "," + result);
                    } else {
                        pw.println(userName + "," + balance);
                    }
                });
    }
    Files.delete(oldfile);
    Files.move(newFile, oldfile); // Or ...