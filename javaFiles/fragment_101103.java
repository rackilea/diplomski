public void createMultipleCustomerDocuments(final String docId, ByteBuffer myCust, int batchSize) throws BackpressureException, InterruptedException {
    //  numDocs is redundant
    ByteBuf buffer = Unpooled.wrappedBuffer(myCust);
    binaryDocuments.add(BinaryDocument.create(docId, buffer)); // ArrayList<BinaryDocument> type
    documentCounter.incrementAndGet();

    System.out.println("Batch size: " + batchSize + " Document Counter: " + documentCounter.get());

    if(documentCounter.get() >= batchSize){
        System.out.println("Document counter: " + documentCounter.get() + " Binary Document list size: " + binaryDocuments.size());
        Observable
        .from(binaryDocuments)
        .flatMap(new Func1<BinaryDocument, Observable<BinaryDocument>>() {
            public Observable<BinaryDocument> call(final BinaryDocument docToInsert) {
                return theBucket.async().upsert(docToInsert);
            } 
        })
        .last()
        .toBlocking()
        .single();
        binaryDocuments.clear();
        documentCounter.set(0);
    }
}