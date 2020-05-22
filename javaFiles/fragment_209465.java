public void bagAllCanned() {
  final Veggie[] canned = new Veggie[cart.canTotal()];
  final Veggie[] bagged = new Veggie[canned.length];
  int t = 0;
  final List<Veggie> veggies = cart.veggies();
  for (int i = 0; i < veggies.size(); i++) {
    final Veggie veggie = veggies.get(i);
    if (veggie.canned()) {
      canned[t] = veggie;
      if (veggie instanceof Potato)
      bagged[t] = Potato.can(veggie);
      else if (veggie instanceof Tomato)
        bagged[t] = Tomato.can(veggie);
      t++;
    }
  }
  for (int i = 0; i < canned.length; i++) {
    veggieChange(canned[i], bagged[i]);
  }
}