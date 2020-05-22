previous = first;
for ( current = first.next; current != null; current = current.next ) {
    if ( current.dvd.equals( oneDvd ) ) {
        previous.next = current.next;
        return;
    }
    previous = current;
}