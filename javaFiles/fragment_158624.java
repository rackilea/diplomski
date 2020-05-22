public void moveOneBox (Box b, int position){    
    Box check;
    System.out.println("Removing "+b.id+" from shelf #"+position);
    check = storage[position].removeBox(b.id);
    System.out.println(check.id);

    for(int i = 0; i< nbShelves ; i++) {
      if(storage[i].height >= b.height && storage[i].availableLength >= b.length) {
        storage[i].addBox(b);
        break;
      }
    }
}