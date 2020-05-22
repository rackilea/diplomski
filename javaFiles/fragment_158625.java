public void reorganize (){   
    Box compare;
    print();
    for(int i = 0; i < nbShelves; i++) {
      compare = storage[i].firstBox;

      while(compare != null) {
        Box nextCompare = compare.next;
        moveOneBox(compare, i);
        compare = nextCompare;

       }
    }
}