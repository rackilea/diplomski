public void aMethod (String activateTime, String expireTime) {
    Date example = new Date(dateFormat.parse(activateTime).getTime());
    Date example2 = new Date(dateFormat.parse(expireTime).getTime());
    System.out.println(example.toString() + " vs " + dateFormat.format(example));
    System.out.println(example2.toString() + " vs " + dateFormat.format(example2));
}