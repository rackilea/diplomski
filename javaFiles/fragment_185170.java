ArrayList<Integer> nr = new ArrayList<Integer>();

nr.add(0);
nr.add(1);
nr.add(2);
nr.add(3);
nr.add(4);
nr.add(5);
nr.add(6);
nr.add(7);
nr.add(8);
nr.add(9);

Random r = new Random();

int rndPos1 = r.nextInt(nr.size());
int rnd1 = nr.remove(rndPos1);

int rndPos2 = r.nextInt(nr.size());
int rnd2 = nr.remove(rndPos2);

int rndPos3 = r.nextInt(nr.size());
int rnd3 = nr.remove(rndPos3);

System.out.println(rnd1 + ", " + rnd2 + ", " + rnd3);