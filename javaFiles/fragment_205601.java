String ipAddr = "192.168.112.33";

//If your pattern match with your String then it is correct else it is not
if (ipAddr.matches("192\\.168\\.(.*?)\\.33")) {
    System.out.println("CORRECT");
} else {
    System.out.println("NOT CORRECT");
}