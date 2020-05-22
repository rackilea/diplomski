public void instanceSync() {
    synchronized( this ) {
        System.out.println("...");
        testList.add( 1 );
    }
}