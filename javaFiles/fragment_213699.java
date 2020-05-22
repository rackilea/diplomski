IndexSearcher searcher = new IndexSearcher(directory);
    IndexReader reader = searcher.getIndexReader();
    RegexTermEnum regexTermEnum = new RegexTermEnum(reader, new Term(
            "field", "d.*"), new JavaUtilRegexCapabilities());

    do {
        System.out.println("Next:");
        System.out.println("\tDoc Freq: " + regexTermEnum.docFreq());
        if (regexTermEnum.term() != null) {             
            System.out.println("\t"+regexTermEnum.term());
            TermDocs td = reader.termDocs(regexTermEnum.term());
            while(td.next()){
                System.out.println("Found "+ td.freq()+" matches in document " + reader.document(td.doc()).get("name"));
            }
        }
    } while (regexTermEnum.next());
    System.out.println("End.");