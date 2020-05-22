Bird {
    Mate();
    Fly();
    Swim();
}

Eagle : Bird {
    Mate() { /* :) */ }
    Fly() { /* Oh come on, of course I can. */ }
    Swim() { /* Oops, sorry I can't. */ }
}

Penguin : Bird {
    Mate() { /* :) */ }
    Fly() { /* Sorry I'm a flightless bird. */ }
    Swim() { /* Yeah, I can do this well. */ }
}