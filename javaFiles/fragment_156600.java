List<SedementaryMineral> list = new ArrayList<>();
list.put(new SedimentaryMineral());

List<IMineral> mineralList = list;
mineralList.add(new NonSedimentaryMineral());

for(SedementaryMineral m : list) {
    System.out.println(m); // what happens when it gets to the NonSedimentaryMineral?
}