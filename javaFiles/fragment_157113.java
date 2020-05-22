public String[] getColumnsInColumnFamily(Result r, String ColumnFamily)
{

      NavigableMap<byte[], byte[]> familyMap = r.getFamilyMap(Bytes.toBytes(ColumnFamily));
      String[] Quantifers = new String[familyMap.size()];

      int counter = 0;
      for(byte[] bQunitifer : familyMap.keySet())
      {
          Quantifers[counter++] = Bytes.toString(bQunitifer);

      }

      return Quantifers;
}