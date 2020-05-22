if (count == num) {
    Link n = new Link(data);
    n.next = current;
    current.previous.next = n;
    n.previous = current.previous;
    current.previous = n;
}