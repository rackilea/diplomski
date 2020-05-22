try {
    try (final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new CipherOutputStream(new FileOutputStream(file), dcipher), "UTF-8"))) {
        writer.append(data);
    }
} catch (IOException ex) {
    e.printStackTrace();
}