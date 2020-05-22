static <T extends ICode> T getObject(String code, List<T> list)
{
  for (T item : list)
  {
     if (item.getCode().equals(code)) return item;
  }
  return null;
}