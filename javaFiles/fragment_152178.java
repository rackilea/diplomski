public class PrimeNumberTestGenerator : Iterable<int>
{
    private int limit;
    private PrimalityTester tester;

    public PrimeNumberTestGenerator(PrimalityTester tester, int limit)
    {
        this.tester = tester;
        this.limit = limit;
    }

    private class PrimeNumberIterator : Iterator<int>
    {
        private int current;

        public PrimeNumberIterator()
        {
        }

        public bool hasNext()
        {
            return next < limit;
        }

        public int moveNext()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            int result = next;

            do
            {
                next++;
            } while(hasNext() && !tester.isPrime(next));


            return result;
        }

        public void remove()
        {
            throw new UnsupportedOperationExecution();
        }
    }

    public Iterator<int> iterator()
    {
        return new PrimeNumberIterator();
    }
}