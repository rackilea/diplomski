@Override
  public boolean equals(Object o) {
     if (!(o instanceof Foo){ 
       return false;
     }
     Foo other = (Foo) o;
     return Objects.equals(other.value, this.value);
  }