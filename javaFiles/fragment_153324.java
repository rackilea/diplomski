function MyIterable(iterable)
{
    this.iterable = iterable;
}

MyIterable.prototype.__iterator__ = function() {
    return new MyIterator(this.iterable.iterator());
};

function MyIterator(iterator) {
    this.iterator = iterator;
}

MyIterator.prototype.next = function() {
    if (this.iterator.hasNext())
        return this.iterator.next();
    else
        throw StopIteration;
};

for (var item in new MyIterable(webapi.getItems()))
{
    //do something with item [..]
}