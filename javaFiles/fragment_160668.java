class MyList<N extends Number> extends ArrayList<N> {}

<K> void add1(MyList<K> a, K b) {
     a.add(b); // Given the method declaration, this line is legal, but it 
          // violates type safety, since object of an arbitrary type K can be
          // added to a list that expects Numbers
          // Thus, declaration of this method is illegal
}

<K> void add2(MyList<? extends K> a, K b) {
     // a.add(b) would be illegal inside this method, so that there is no way
     // to violate type safety here, therefore declaration of this method is legal
}

<K> void add3(MyLisy<? super K> a, K b) {
     a.add(b); // This line is legal, but it cannot violate type safey, since
          // you cannot pass a list that doesn't expect K into this method
}