Object lock = new Object();

for (int i = 0; i < verifier.length; i++) {
    verifier[i]=new Thread(new Verifier(main.database,i+1, lock));
    verifier[i].start();
}

...
public int getRow() throws SQLException{
    synchronized(lock) {
        ...
    }
}