public class yourClass
{
    private List<String> vocabulary = new ArrayList<String>();

    public List<String> makeVocabulary(String[] tokens)
    {
        for( int i = 0; i < tokens.length; i++ )
            if( !vocabulary.contains( tokens[i] ) )
                vocabulary.add(tokens[i]);
        return vocabulary;
    }
}