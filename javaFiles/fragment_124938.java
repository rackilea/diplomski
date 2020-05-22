public void setSocNum(String x) {

    if (Pattern.matches("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", x)) {
        System.out.println("please enter a valid social security number");
    }
    // further logic goes here
}