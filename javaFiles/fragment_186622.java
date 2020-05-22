PreparedStatement ps = conn.prepareStatement("INSERT INTO Files VALUES(?)");
File userDir = new File(System.getProperty("user.dir"));
File[] files = userDir.listFiles();
for (File f : files) {
    if (f.isFile()) {
        ps.setString(1, f.getAbsolutePath());
        ps.executeUpdate();
    }
}