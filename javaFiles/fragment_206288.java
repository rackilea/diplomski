final Bag vowels = makeLetterBag(type);
final Bag consonants = makeLetterBag(type);

private static IBag makeLetterBag(BagType type) {
    switch (type) {
    case RESIZABLE:
        return new ResizableArrayBag<String>();
    case LINKED_LIST:
        return new LinkedListBag<String>();
    }
}