Hashtable<Integer, Integer> hits = new Hashtable<Integer, Integer>();
while (spans.next() == true)
{
     int docID = spans.doc();
     int hit = hits.get(docID) != null ? hits.get(docID) : 0;
     hit++;
     hits.put(docID, hit);
}