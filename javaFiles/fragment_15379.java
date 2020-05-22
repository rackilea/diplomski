class AmericanFootball extends Sports {
}

class Soccer extends Sports {
}

class Football<T extends Sports> {
}

Football<AmericanFootball> anAmericanFootball;
Football<Soccer> aSoccerBall;