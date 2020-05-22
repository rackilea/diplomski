public void scan(Set<PlugIn> plugIns) {
  if (plugIns == null) throw new NullPointerException("plugIns");
  for (PlugIn plugIn : plugIns) {
    if (plugIn == null) throw new NullPointerException("plugIns null element");
  }
}