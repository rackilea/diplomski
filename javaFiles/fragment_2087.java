byte[] bytes;
try {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(/* size hint */);
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeInt(age);
    dos.writeBoolean(gender.equals('m'));
    dos.writeInt(children);
    dos.writeBoolean(goodHealth);
    dos.writeInt(cars);
    dos.writeInt(avgWeekShopping);
    dos.writeInt(salary);
    dos.writeBoolean(smoker);
    bytes = baos.toByteArray();
} catch (IOException ex) {
    throw new AssertionError("this can't happen", ex);
}