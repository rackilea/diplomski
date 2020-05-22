ArrayList<String> s = new ArrayList<String>();
s.add("sox/sox");              // command/process

// everything after this is an argument
s.add(srcFile.getPath());
s.add("-b 16");
s.add(destFile.getPath());
s.add("rate");                 // notice how I had to split up the rate argument
s.add("16000");  
s.add("channels");             // same applies here
s.add("1");