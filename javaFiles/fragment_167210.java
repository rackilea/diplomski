try {
  modelIn = new FileInputStream("en-pos-maxent.bin");
  POSModel model = new POSModel(modelIn);
}
catch (IOException e) {
  // Model loading failed, handle the error
  e.printStackTrace();
}
finally {
  if (modelIn != null) {
    try {
      modelIn.close();
    }
    catch (IOException e) {
    }
  }
}