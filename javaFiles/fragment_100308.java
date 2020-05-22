public int remove() throws EmptyBagException { // <-- declare throws

    try {
        this.realRemoval();
    } catch (EmptyBagException e){
        System.out.println(e.getMessage());
        throw e; // <-- rethrow
    }

    return -1;

}