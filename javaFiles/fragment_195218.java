static int i = peekj(); // Executed First, as peekJ() directly returns 1 so i is equal to 1
        static int h = peekk(); // Executed Second, Now peekk() returns "THE VALUE OF k" which is not set yet i.e default value of int is given 0(zero)
//So h is equal to 0

        static final int j = 1; // This statement doesn't exist as all j's are replaced with actual Number 1 when we compiled java to .class 
        static int k = 1; // Executed last, So now the value of 'k' is being set, after the value of 'h' has already been set to zero