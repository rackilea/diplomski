String.metaClass.sortCharacters = {
    char[] charArray = delegate.toLowerCase().toCharArray();
    Arrays.sort(charArray)
    return String.valueOf(charArray)
}

assert 'abz' == 'bza'.sortCharacters()