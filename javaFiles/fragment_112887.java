229  public int indexOf(Object o) {
230      if (o == null) {
231          for (int i = 0; i < size; i++)
232              if (elementData[i]==null)
233                  return i;
234      } else {
235          for (int i = 0; i < size; i++)
236              if (o.equals(elementData[i]))
237                  return i;
238      }
239      return -1;
240  }