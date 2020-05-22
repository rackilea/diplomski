boolean firstLine = true;
while (red = br.readLine()) {
  if(firstline && red == null) {
    throw new WrongFileException("Format fajla nije dobar!");
  }
  firstLine = false;
  if(null == red) {
    continue;
  }
  content = red;
  treasuryStatHeader.setTshStatFileContent(content);
  // [...]
}