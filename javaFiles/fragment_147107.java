public Lista(Lista lista1, Lista lista2) {
    // get hold of lisa1.tail
    Element lista1Tail = lista1.getElement(lista1.size() - 1);
    listaTail.next = lista2.head;

    //now pointer back to tail of lista1
    lista2.head.previous = listaTail;
}