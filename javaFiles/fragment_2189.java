List<PDNameTreeNode> kids = embeddedFiles.getKids();
if (kids != null) {
  for (PDNameTreeNode kid : embeddedFiles.getKids()) {
    PDComplexFileSpecification spec =
      (PDComplexFileSpecification) kid.getValue(ZUGFERD_XML_FILENAME);
    PDEmbeddedFile file = spec.getEmbeddedFile();
    return file.getByteArray();
  }
}