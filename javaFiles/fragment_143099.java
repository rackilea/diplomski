File folder = new File("BitTorrent");
for (final File SubFile : folder.listFiles()) {
    if (!SubFile.isDirectory()) {
        **// HOW TO READ ALL THE CONTENT OF SUBFILE WITHOUT USING ITS PATH.**
         byte[] bytes= new byte[(int)SubFile.length()];
         DataInputStream dataIs = new DataInputStream(new FileInputStream(SubFile));
         dataIs.readFully(bytes);
         // here bytes has the content
    }
}