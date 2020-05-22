public class AtkinSieve : Iterable<int>
{
    private BitSet primes;

    public AtkinSieve(int limit)
    {
        primes = new BitSet(limit);

        int root = (int)Math.sqrt(limit);

        primes.set(2);
        primes.set(3);

        //this section can be further optimized but is the approach used by most samples
        for (int x = 1; x <= root; x++)
        {
            for (int y = 1; y <= root; y++)
            {
                int number;
                int remainder;


                number = (4 * x * x) + (y * y);
                remainder = number % 12;
                if (number < limit && (remainder == 1 || remainder == 5))
                {
                    primes.flip(number);
                }

                number = (3 * x * x) + (y * y);
                remainder = number % 12;
                if (number < limit && remainder == 7)
                {
                    primes.flip(number);
                }

                if (x < y)
                {
                    number = (3 * x * x) - (y * y);
                    remainder = number % 12;
                    if (number < limit && remainder == 11)
                    {
                        primes.flip(number);
                    }
                }
            }
        }

        for (int i = 5; i <= root; i++)
        {
            if (primes.get(i))
            {
                int square = i * i;
                for (int j = square; j < limit; j += square)
                {
                    primes.clear(j);
                }
            }
        }
    }
}

public class SetBitIterator : Iterator<int>
{
    private BitSet bits;
    private int next;
    private bool isReadOnly;

    public SetBitIterator(BitSet bits)
    {
        this.bits = bits;
        next = bits.nextSetBit(0);   
    }

    public bool hasNext()
    {
        return next <> -1;
    }

    public int moveNext()
    {
        int result = next;

        next = bits.nextSetBit(next);

        return result;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}