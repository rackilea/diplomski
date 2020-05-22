static {
    /*
     * Want to know why ? http://stackoverflow.com/q/19277018/15619 this is why
     */
    System.setProperty("imq.jmsra.fixCR6760301", Boolean.FALSE.toString());
}