StringBuilder s = new StringBuilder("sox/sox"); // command itself is 'sox'

// everything after this is an argument
s.add(srcFile.getPath());
s.add("-b 16");
s.add(destFile.getPath());
s.add("rate 16000");
s.add("channels 1");