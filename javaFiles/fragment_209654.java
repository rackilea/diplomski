List wordsInFile1 = getWordsFromFile();
List wordsInFile2 = getWordsFromFile();

List foundWords = empty;

//Does below for each compared file
for each word in file 1
    set count to 0
    compare to each word in file 2
        if the word matches see if it's also in foundWords
            if it is in foundWords, add 1 to count
        otherwise, add the word to foundWords

//Write the number of words
prints out the number of words in foundWords