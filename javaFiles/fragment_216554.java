public void test() {
     X x = new X();

     try {
          T temp = tx.method();
          temp.doWhatever();
     }

     catch(SomeException e) { handleException(e); }
}