// Get a default NumberFormat instance.
        NumberFormat numForm = NumberFormat.getInstance();

        // Format some decimals using the pattern supplied above.
        StringBuffer dest1 = new StringBuffer(24);
        StringBuffer dest2 = new StringBuffer(24);
        FieldPosition pos = new FieldPosition(NumberFormat.FRACTION_FIELD);

        dest1 = numForm.format(22.3423D, dest1, pos);
        System.out.println("dest1 = " + dest1);
        System.out.println("FRACTION is at: " + pos.getBeginIndex() +
            ", " + pos.getEndIndex());

        dest2 = numForm.format(64000D, dest2, pos);
        System.out.println("dest2 = " + dest2);
        System.out.println("FRACTION is at: " + pos.getBeginIndex() +
            ", " + pos.getEndIndex());
/*
Output:
dest1 = 22.342
FRACTION is at: 3, 6
dest2 = 64,000
FRACTION is at: 6, 6
*/