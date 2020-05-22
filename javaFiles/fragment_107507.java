/*
 * @author  DaveCat
 * @version 1.0
 * @since   2019-03-9 
 * Convenience method that calculates 90% odds of A and 10% odds of B.
 *
 */
    public static String[] calculatesNinetyPercent()
    {
        Random random = new Random();
        int x = random.nextInt(10 - 1 ) + 1
        //Option A
        if(x <= 9) {
            return stringArray(0);
        }
        else
        {
        //Option B
            return stringArray(1);
        }
    }