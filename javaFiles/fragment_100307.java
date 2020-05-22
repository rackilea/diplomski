public int remove() {

    try {
        this.realRemoval();
    } catch (EmptyBagException e){
        System.out.println(e.getMessage());
    }

    return -1;
}