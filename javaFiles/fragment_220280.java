public void addCard(Card card)
{
    if(card != null)
    {
        Cards[counter] = card;
        setCounter(counter+1);
    }
    else
        System.out.println("NO NO NO! Trying to add a null card to your hand");
}