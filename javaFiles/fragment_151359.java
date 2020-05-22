BufferedWriter writer = new BufferedWriter(new FileWriter(String));
while (true) {
    CharSequence word = in.take();
    if (word.toString().equalsIgnoreCase(END_FLAG)) {
        break;
    }
    try {
        writer.write(word + " ");
    } catch (IOException io) {
        break;
    }
}
writer.close();