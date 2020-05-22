interface Deckable {
    void takeAction();
}
interface Card extends Deckable {
    int getRank();
    int getSuit();
}
class PlayingCard implements Card {
    ...
}
class SpecialActionCard implements Deckable {
    ...
}