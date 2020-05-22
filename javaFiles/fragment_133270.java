HashSet<Integer> integers = new HashSet<>();
for (int i = 0; i <= 400; i++)
    if ((hash(i) & 0x1f) == 0)
        integers.add(i);
HashSet<Integer> integers2 = new HashSet<>();
for (int i = 400; i >= 0; i--)
    if ((hash(i) & 0x1f) == 0)
        integers2.add(i);
System.out.println(integers);
System.out.println(integers2);


static int hash(int h) {
    // This function ensures that hashCodes that differ only by
    // constant multiples at each bit position have a bounded
    // number of collisions (approximately 8 at default load factor).
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}