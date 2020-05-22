public class MobScene {
        private HashMap<Integer, Integer> mobs = new HashMap<Integer, Integer>(10);
        // Note that '10' is the initial capacity of the Collection.
        // I only use it as I already know the given capacity and avoid extra memory being reserved.

        public MobScene() {
            mobs.put(9300127,2);
            mobs.put(9300128,2);
            mobs.put(9300129,2);
            mobs.put(9300130,3);
            mobs.put(9300131,3);
            mobs.put(9300132,3);
            mobs.put(9300133,4);
            mobs.put(9300134,4);
            mobs.put(9300135,5);
            mobs.put(9300136,6);
        }

        public void addPoints(int mobid) {
            if(mobs.contains(mobid)) {
                mobs.put(mobs.get(mobid) + 1);
            }
        }
    }