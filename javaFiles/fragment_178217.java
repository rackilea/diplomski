SentenceIterator iter = new CollectionSentenceIterator(DataFetcher.getFirstDataset());
Word2Vec vec = new Word2Vec.Builder()
            .iterate(iter)
            ....
            .build();

vec.fit();

vec.wordsNearest("clear", 10); // you will see results from first dataset

SentenceIterator iter2 = new CollectionSentenceIterator(DataFetcher.getSecondDataset());
vec =  new Word2Vec.Builder()
    .iterate(iter2)
    ....
    .build();

vec.fit();

vec.wordsNearest("clear", 10); // you will see results from second dataset, without any first dataset implication