List<ABC> abcList = new ArrayList<ABC>();

for (int i = 0; i < 10; i++) {
    ABC abc = new ABC();//You have to re-initialise your variable each time.
    abc.setX(i);
    abc.setY(i - i * 2); 
    abcList.add(abc);
}
System.out.println(abcList.get(0).getY());