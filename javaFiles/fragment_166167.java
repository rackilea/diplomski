static void deleteFlaggedEntries(Map<?, ?> readwrite, Map<?, ?> readonly)
{
  Iterator<?> keys = readwrite.keySet().iterator();
  while (keys.hasNext()) {
    if ("Y".equals(readonly.get(keys.next())))
      keys.remove();
  }
}