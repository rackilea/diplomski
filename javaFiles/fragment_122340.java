class ReaderTuple<T> {
   final Reader first;
   final T second;
   ReaderTuple(Reader r, T s){
     first = r;
     second = s;
   }
}