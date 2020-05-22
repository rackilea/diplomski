File f = new File("temp/file.txt");
if (!f.exists()) {
  return;
}
Scanner scanner = null;
List<String> al = new ArrayList<String>();
try {
  scanner = new Scanner(f);
  while (scanner.hasNextLine()) {
    String line1 = scanner.nextLine().trim();
    if (line1.length() == 0) {
      continue;
    }
    String line2 = "";
    if (scanner.hasNextLine()) {
      line2 = scanner.nextLine().trim();
    }
    if (line2.trim().length() > 0) {
      al.add(line1 + ", " + line2);
    } else {
      al.add(line1);
    }
  }
} catch (FileNotFoundException e) {
  e.printStackTrace();
} finally {
  scanner.close();
}
FileOutputStream fos = null;
try {
  fos = new FileOutputStream(f, false);
  PrintWriter pw = new PrintWriter(fos);
  for (String str : al) {
    pw.println(str);
  }
  pw.close();
} catch (FileNotFoundException e) {
  e.printStackTrace();
} finally {
  if (fos != null) {
    try {
      fos.close();
    } catch (IOException e) {
    }
  }
}