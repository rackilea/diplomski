public ConsonantCounter(char bagImplementationClass){
    Bag vowels;
    Bag consonants;
    if (bagImplementationClass == 'A'){
        vowels = new ResizableArrayBag<String>();
        consonants = new ResizableArrayBag<String>();
    } else if (bagImplementationClass == 'L'){
        vowels = new LinkedListBag<String>();
        consonants = new LinkedListBag<String>();
    }
    // ...
}