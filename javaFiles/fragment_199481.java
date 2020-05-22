public int i = 0;

public void update() {
  int i = 10; // this does not in any way touch the above-declared "i"
}

public void updateProperly() {
  i = 10; // this _does_ use the above-declared "i"
}