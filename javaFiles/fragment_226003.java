public static final int NUM_DIGITS = 4 ;
public static final int MAX = (int) Math.pow(10, NUM_DIGITS) ;
public static final int MIN = MAX / 10 ;


public static int biggestLoser(int a, int b) {
    return (a < MIN || a >= MAX || b < MIN || b >= MAX) ? Math.min(a, b) :
        IntStream.iterate(1, multiplier -> multiplier * 10).limit(NUM_DIGITS)
            .map(multiplier -> Math.min((a / multiplier) % 10, (b / multiplier) % 10) * multiplier )
            .sum();
}