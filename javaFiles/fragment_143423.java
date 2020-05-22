while (r2.next()) {
   Object[] result = map.get(rs2.getInt(1));
   if (result != null) {
      ...
   }
}