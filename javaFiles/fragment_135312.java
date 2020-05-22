Session hb = ...;
Transaction tx = ...;
hb.setCacheMode(CacheMode.IGNORE);
hb.setFlushMode(FlushMode.COMMIT);
for (List<Item> chunk : chunks) {
  ... process chunk ...
  hb.flush();
  hb.clear();
}
hb.commit();
tx.close();