if (myList3.head == null)
    myList3.head = myList1.head;
else {
    Node list3iter = myList3.head;
    while (list3iter.getLink() != null) {
        list3iter = list3iter.getLink();
    }
    list3iter.setLink(myList1.head);
    }
}