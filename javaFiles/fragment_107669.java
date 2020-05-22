List<AbstractOrderEntryModel> list=source.getEntries()
final Collection<AbstractOrderEntryModel> orderEntry = Collections2.filter(list,
  new Predicate<AbstractOrderEntryModel>()
  {
    public boolean apply(final AbstractOrderEntryModel arg)
    {
        return arg.getBasePrice().doubleValue() == 0;
    }
  });
if(!orderEntry.isEmpty()) {
  assert orderEntry.size()==1; // so you said in your question
  AbstractOrderEntryModel e=orderEntry.iterator().next();
  list.remove(e);
  list.add(e);
}