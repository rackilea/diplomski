LinkedList<Long> to_remove = new LinkedList<Long>();
    for(int i = 0; i < this.mylist.size(); i++) {

        Long current = this.mylist.get(i);
        if(conditionToRemove)
            to_remove.add(current);
    }
    this.mylist.removeAll(to_remove);