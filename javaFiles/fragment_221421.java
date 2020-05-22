for (int i = 0; i < prices.length; i++) {
    buf.putDouble(prices[i]);
    buf.putInt(units[i]);

    byte[] descsBytes = descs[i].getBytes();
    buf.putInt(descsBytes.length);
    buf.put(descsBytes);
}