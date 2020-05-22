@Override
public boolean hasNext() {
    try { 
        return currentIndex <= currentSize && items[currentIndex] != null;
    }
    catch(NoSuchElementException e) {
        System.out.println("There is nothing in the next element.");
    }

    return currentIndex <= currentSize && items[currentIndex] != null;
}