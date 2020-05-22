public void addFirst(String aString) {
        Link link = new Link();
        link.setValue(aString);

        if (isEmpty()) {
            tail = link;
        } else {
            link.setNext(head);
        }
        head = link;
    }