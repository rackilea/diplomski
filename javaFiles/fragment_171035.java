while ((line = textReader.readLine()) != null) {

    // I tried this:
    if (line.contains("//")) {
      continue;
    }

    numberOfLines++;

}