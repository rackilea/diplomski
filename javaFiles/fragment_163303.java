//this method takes two collections
//that means that you can pass any type of collection (including list) to it
//the advantage is that you could also pass another type of collection if you chose to do so
private void removeColors(Collection<String> collection1,Collection<String> collection2)
{
    Iterator<String> iterator = collection1.iterator();//this line takes the iterator of your first collection
    //an iterator is an object that allows you to go through a collection (list)
    //you can get the objects one by one by calling the next() method
    while(iterator.hasNext())//basically, that's what you're doing here:
    //you let the loop continue as long as there are more items inside the iterator, that is, the first collection
        if(collection2.contains(iterator.next()))//so if there's another item, you take it by calling next() and check if the second collection contains it
            iterator.remove();//if that's the case, you remove the item from the first collection
}
//what you've basically achieved:
//you removed all the items from the first collection that you can find in the second collection as well, so you could say:
//collection1 = collection1 - collection2