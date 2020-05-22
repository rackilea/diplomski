dictionary = read wikipedia dictionary
document = a sequence of documents
documents.map { doc =>
  var docTermFreq = Map[String, Int]()
  for(term <- doc.terms.map if(dictionary.contains(term)) ) {
     docTermFreq = docTermFreq + (term -> docTermFreq.getOrElse(term, 0) + 1)
  }
  // store docTermFreq map
}