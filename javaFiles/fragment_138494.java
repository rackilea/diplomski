public boolean passCard(CardContainer cc, Card c)
{
    for(int i = 0; i < cards.length; i++)
    {
        if(cards[i].equals(c)) 
        {       
            h.cards[i] = this.cards[i];
            return true;
        }
    }
    return false;
}