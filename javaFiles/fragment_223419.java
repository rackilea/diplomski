public boolean equals(Object o) {
  if (this == o)
     return true;
  if (o == null)  // this extra check is needed to avoid a NPE
    return false;
  if (o.getClass() == this.getClass()) {  // must be an exact match
     FooA oFoo = (FooA)o;
     // compare all the fields here
  }

  return false;
}