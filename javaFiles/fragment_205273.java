List<Files> directories = new ArrayList<> ();
if (file is directory) directories.add(file);
else dowloadFile();

for (File f : directories) {
  cd(f);
  ftpFiles(listFiles());
  cd(..);
}