Map<MyPair,Integer> freq = new HashMap<MyPair,Integer>();
MyPair pair1 = new MyPair("F1", "F2");
freq.get(pair1); // => null
freq.put(pair1, 1);
MyPair pair2 = new MyPair("F2", "F1");
freq.get(pair2); // => 1