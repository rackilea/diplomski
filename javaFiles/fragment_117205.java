LinkedList<Month> monthList = new LinkedList<Month>();
var i = monthList.getIterator();
for(Event ev : events)
{
    shiftList(monthList, i, ev);
    for(Month m : monthList)
    {
        if (!isInMonth(ev, m)) break;
        m.addEvent(ev);
    }
}

...

// Remove months that are not in scope from the front of the list.
// Add months that are in scope to the end of the list
public void shiftList(LinkedList<Month> monthList, Iterator<Month> i, Event ev)
{
    while(!monthList.size() > 0 && !isInMonth(ev, monthList.getFirst()))
    {
        monthList.removeFirst();
    }
    while(i.hasNext() && isInMonth(ev, monthList.getLast()))
    {
        monthList.addLast(i.next());
    }
}