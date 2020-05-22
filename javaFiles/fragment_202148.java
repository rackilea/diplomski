final MiniFoodFreezer miniFoodFreezer = new MiniFoodFreezer();
miniFoodFreezer.add(new IceCream());
miniFoodFreezer.add(new SnoCone());
miniFoodFreezer.add(new Slushy());

for (final Freezeable freezable : miniFoodFreezer.asFreezables()) {
    // do freezable stuff
}

for (final Edible edible : miniFoodFreezer.asEdibles()) {
    // do edible stuff
}

for (
        final SmallerThanABeachball smallerThanABeachBall :
        miniFoodFreezer.asSmallerThanBeachballs()
) {
    // do smaller-than-a-beach-ball stuff
}