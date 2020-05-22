int numberOfDocsInBatch = 0;
...
writer.addDocument(doc);
numberOfDocsInBatch ++;
if (numberOfDocsInBatch == 1_000_000) {
   writer.commit();
   numberOfDocsInBatch = 0;
}