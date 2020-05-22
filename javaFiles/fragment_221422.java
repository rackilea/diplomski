while (buf.hasRemaining()) {

    price = buf.getDouble();
    unit = buf.getInt();

    int len = buf.getInt();
    byte[] bytes = new byte[len]; 
    buf.get(bytes);
    desc = new String(bytes);

    System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                unit, desc, price);
    total += unit * price;
}