interface Foo { /* ... */ }

class Bar implements Foo { /* ... */ }

class Factory {
  Foo makeFoo() { 
    return new Bar( /*... */ );
  }
}