Bird {
    Mate();
}

Eagle : Bird, ICanFly {
    Mate() { }
    Fly() { }
}

Penguin : Bird, ICanSwim {
    Mate() { }
    Swim() { }
}