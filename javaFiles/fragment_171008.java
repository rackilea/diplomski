final List<String> stopWords = Arrays.asList(
   "a", "an", "and", "are", "as", "at", "be", "but", "by",
   "for", "if", "in", "into", "is", "it",
   "no", "not", "of", "on", "or", "such",
   "that", "the", "their", "then", "there", "these",
   "they", "this", "to", "was", "will", "with"
 );
 final CharArraySet stopSet = new CharArraySet(Version.LUCENE_CURRENT, 
     stopWords, false);