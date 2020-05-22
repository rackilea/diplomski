public void insert(Card card)
{
    Link newLink = new Link(card);
    newLink.next = first;

    if (card.rank == 1 && cardTotal + card.getValue() > 21)
        cardTotal = cardTotal + (card.getValue() - 10);
    else
        cardTotal = cardTotal + card.getValue();

    first = newLink;
}