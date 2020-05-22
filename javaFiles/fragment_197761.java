GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
Collection tdl = gs.typedDependenciesCollapsed();

System.out.println("words: "+words); 
System.out.println("POStags: "+tags); 
System.out.println("stemmedWordsAndTags: "+stems); 
System.out.println("typedDependencies: "+tdl);