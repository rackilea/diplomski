private boolean checkNumber(String number) {
        //number consists of 12 digits
        String firstGroup = number.substring(0, 3);
        String secondGroup = number.substring(3, 10);
        String thirdGroup = number.substring(10, 12);

        int firstSecond = Integer.parseInt(firstGroup + secondGroup);
        int third = Integer.parseInt(thirdGroup);

        int remainderAfterDevision = firstSecond % 97;

        return (remainderAfterDevision == third);
}