while (!aPhone.moved()) {
    if(thePhones.stream().filter(e -> !e.equals(aPhone)).anyMatch(PhoneX1::moved)) {
       //Do something
    }
    Thread.sleep(1000);
}