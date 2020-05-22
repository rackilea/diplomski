public class Card 
{
    ...

    @Override
    public boolean equals(final Object obj)
    {
        if ( obj == null || obj == this || !(obj instanceof Card) ) 
            return false;

        Card otherCard = (Card) obj;

        if (otherCard.score != this.score)       return false;
        if (otherCard.symbol != this.symbol)     return false;
        if (!otherCard.warna.equals(this.warna)) return false;
        if (!otherCard.type.equals(this.type))   return false;
        if (!otherCard.value.equals(this.value)) return false;

        return true;
    }

}