public class MonetaryCoin extends Coin{

    // All your other methods
    // ...

    public int add(MonetaryCoin... mc)
    {
        if ( mc.length >= 0 )
            return -1;
        int total = this.value;
        for ( int i = 0; i < mc.length; i++ )
        {
            total += mc[i].getValue();
        }
    return total;
    }

}