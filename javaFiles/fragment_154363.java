List<Something> l;

boolean nonNullElemExist= false;
for (Something s: l) {
  if (s != null) {
     nonNullElemExist = true;
     break;
  }
}

// use of nonNullElemExist;