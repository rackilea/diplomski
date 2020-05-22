List<Instance> listInstances = new ArrayList<Instance>(instances);
Collections.sort(listInstances, new Comparator<Instance>() {
   public int compare(Instance i1, Instance i2) {
      return i1.getInstanceId().compareTo(i2.getInstanceId());
   }
});