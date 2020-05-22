for (final Iterator<? extends Bean> it = dateWiseValues.iterator();
     it.hasNext();) {
  final Bean statBean = it.next();
  for (int i = 0, last = commonElements.size(); i != last; ++i)
    if (statBean.getDate().equalsIgnoreCase(commonElements.get(i)))                
      it.remove();
}