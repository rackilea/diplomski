String string = "string";
File file = new File(this.getFilesDir(), string);

BufferedWriter out = new BufferedWriter(new FileWriter(file));
out.write("I am a line of text written in" + file);
out.close();