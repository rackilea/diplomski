try {
      outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
      ObjectOutputStream oos = new ObjectOutputStream(outputStream);
      oos.writeObject(set);
      oos.close();
    } catch (Exception e) {
      e.printStackTrace();
}