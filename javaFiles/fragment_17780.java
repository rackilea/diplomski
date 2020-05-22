...
onError(Exception e) {
   try {
       throw e;
   } catch (IOException ioe) {
      // do smth with ioe
   } catch (MyException mye) {
      // do smth with mye
   }
}
...