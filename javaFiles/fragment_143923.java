Iterator<A> iter1 = list1.iterator();
Iterator<B> iter2 = list2.iterator();

int sameCounter = 0;

while (iter1.hasNext() && iter2.hasNext())
    if (iter1.next().equals(iter2.next()))
        sameCounter++;