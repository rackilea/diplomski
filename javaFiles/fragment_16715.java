@SuppressWarnings("unchecked")
  private static ArrayList<Integer> extractArrayListInteger(SelectedCriteria criteria)
  {
    ArrayList<Integer> values = new ArrayList<>();
    for (Object v : (ArrayList<Object>) criteria.getValue())
    {
      values.add(Integer.valueOf(v.toString()));
    }
    return values;
  }

  @SuppressWarnings("unchecked")
  private static ArrayList<String> extractArrayListString(SelectedCriteria criteria)
  {
    ArrayList<String> values = new ArrayList<>();
    for (String v : (ArrayList<String>) criteria.getValue())
    {
      values.add(v);
    }
    return values;
  }