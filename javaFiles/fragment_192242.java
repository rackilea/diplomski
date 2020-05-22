private void one() {
  while(true) {
    try {
        //Valid data
        break;
    }catch(InvalidArgumentException e) { // or what ever you expect.
        two();
    }
  }
}

private void two() {
     //Process data with another input
     //On entry,
}