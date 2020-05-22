for ( String[] fields : rows ) {
    Map<String, ByteArrayOutputStream> map = new HashMap<String, ByteArrayOutputStream>();
    String key = fields[0] + "_" + fields[1];
    byte quality = Byte.parseByte(fields[10].substring(3));
    double score = Double.parseDouble(fields[11]);

    if ( !map.containsKey(key) ) {
        map.put(key, new ByteArrayOutputStream());
    }
    DataOutputStream dos = new DataOutputStream(map.get(key));
    dos.writeByte(quality);
    dos.writeDouble(score);
}


//reading
for ( String key : map.keySet() ) {
    ByteArrayOutputStream baos = map.get(key);
    int numHits = baos.size()/9; //1 byte for quality, 8 for score
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
    System.out.print( key + " - " + numHits);
    while ( din.available() > 0 ) {
        byte quality = din.readByte();
        double score = din.readDouble();
        System.out.print(" (" + quality + ", " + score + ")");
    }
    System.out.print("\n");
}