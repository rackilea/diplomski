List<String> result = new ArrayList<String>();
RocksIterator iterator = db.newIterator();
for (iterator.seek(prefix.getBytes()); iterator.isValid(); iterator
                .next()) {
           String key = new String(iterator.key());
            if (!key.startsWith(prefix))
            break;
      result.add(String.format("%s", new String(iterator.key())));
}