public static void main(String[] args)
{
        DBConfig db = new   DBConfig("localhost/uby_database","com.mysql.jdbc.Driver","mysql","user", "password", true, false);
        Uby uby = new Uby(db);
        Lexicon lex = uby.getLexiconByName("WiktionaryEN");
        List<LexicalEntry> entries = uby.getLexicalEntries("align", EPartOfSpeech.verb, lex);
        for (LexicalEntry le : entries) 
        {
                for (Sense s: le.getSenses())
                {
                        System.out.println("Wiktionary Sense:"+s.getDefinitionText());
                        List<SenseAxis> alignedSenses = uby.getSenseAxisBySense(s);
                        if(alignedSenses.size()>0)
                        {
                                for(SenseAxis axis : alignedSenses)
                                {
                                     String definition =  axis.getSenseOne().getDefinitionText();
                                     if(definition.length()==0)
                                     {
                                        definition = axis.getSenseOne().getSynset().getDefinitionText();
                                     }
                                     System.out.println("Aligned Sense:" +definition);
                                }
                        }
                }
        }
}