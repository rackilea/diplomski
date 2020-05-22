public class PatternSearch{

    enum StringComparator implements Comparator<String>{
        LENGTH_THEN_ALPHA{

            @Override
            public int compare(final String first, final String second){

                // compare lengths
                int result =
                    Integer.valueOf(first.length()).compareTo(
                        Integer.valueOf(second.length()));
                // and if they are the same, compare contents
                if(result == 0){
                    result = first.compareTo(second);
                }

                return result;
            }
        }
    }

    private final SortedSet<String> data =
        new TreeSet<String>(StringComparator.LENGTH_THEN_ALPHA);

    public boolean addWord(final String word){
        return data.add(word.toLowerCase());
    }

    public Set<String> findByPattern(final String patternString){
        final Pattern pattern =
            Pattern.compile(patternString.toLowerCase().replace('*', '.'));
        final Set<String> results = new TreeSet<String>();
        for(final String word : data.subSet(
            // this should probably be optimized :-)
            patternString.replaceAll(".", "a"),
            patternString.replaceAll(".", "z"))){
            if(pattern.matcher(word).matches()){
                results.add(word);
            }
        }
        return results;
    }

}