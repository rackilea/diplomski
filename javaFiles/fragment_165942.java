for (Fish fish : fishesCaught) {
   if (fisher.like(fish)) {
       fisher.keep(fish);
   } else {
       pond.addFish(fish);
   }
}
fishesCaught.clear();