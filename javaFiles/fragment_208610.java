public void remove(Class<? extends Transaction> cls) {
    Iterator itr = transactions.iterator();

    while (itr.hasNext()) {
        if (itr.next().getClass().equals(cls)) {
            System.out.println("removing");
            itr.remove();
        }
    }
}