private String[] dictionaryArray; 

public void dictionaryRead() throws FileNotFoundException {
    ...
    // Note how String[] is removed on the line below:
    dictionaryArray = dictionary.toArray(new String[0]);
}