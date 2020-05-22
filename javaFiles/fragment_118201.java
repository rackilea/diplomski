StringBuilder str = new StringBuilder();

for (File f : new File("your folder").listFiles()) {
    if (f.isFile()) {
        str.append(' ').append(f.getPath());
    }
}