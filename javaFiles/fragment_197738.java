List arrist = new ArrayList();
arrlist.add(listtext);
a1.setText("");
try {
  FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
  ObjectOutputStream oos = new ObjectOutputStream(fos);