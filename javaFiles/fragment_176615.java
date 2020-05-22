public void writeToFile(LinkedBlockingQueue<CustomObject> sharedList) {
      List<CustomObject> subList = new ArrayList<>();
      sharedList.drainTo(subList);
      FileWriterUtil.appendToFile(fileName, subList);
      subList.clear();
}