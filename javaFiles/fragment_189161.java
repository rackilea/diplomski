Dataset dataset = TDBFactory.createDataset(tdbPath);
Model model = dataset.getDefaultModel();
InputStream str = FileManager.get().open(filePath);
if (useGZIP) {
   str = new GZIPInputStream(str);
}
model.read(str,null, "N-TRIPLES");