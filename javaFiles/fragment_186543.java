File file = new File("foo.txt");
    String[] data = getMyData();// replace the method call with whatever you need
    final FileOutputStream fos = new FileOutputStream(file);
                final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
    for (final String s : data) {
                writer.write(s);
                writer.newLine();
    }