Set<Object> set = ...;
Random random = new Random(); // or some better RNG
int size = set.size();
int step1 = rand.nextInt(size - 1);
int step2 = rand.mextInt(size - step1);

Iterator<Object> iter = set.iterator();
for (int i = 0; i < step1 - 1; ++i) {
    iter.next();
}
Object rand1 = iter.next();

for (int i = 0; i < step2 - 1; ++i) {
    iter.next(); // Note, this is the SAME iterator!
}
Object rand2 = iter.next();