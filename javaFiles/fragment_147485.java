Terms vector = indexReader.getTermVector(id, field);
if (vector != null) {
    TermsEnum vectorEnum = vector.iterator();
    BytesRef text;
    while ((text = vectorEnum.next()) != null) {
        String term = text.utf8ToString();
        PostingsEnum postings = vectorEnum.postings(null, PostingsEnum.POSITIONS);
        while (postings.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
            int freq = postings.freq();
            while (freq-- > 0)
                logger.info("Position: {}", postings.nextPosition());
        }
    }
}