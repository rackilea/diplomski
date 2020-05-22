@Data @AllArgsConstructor
class E {
    int id, priority;
    public String toString() { return String.format("%d/%d", id, priority); }
}

Random random = new Random();
int id = 0;
for (int i = 0; i < 50; i++) {
    test.insert(new E(id++, random.nextInt(20)));
}
System.out.println(test.q);
// [2/19, 3/19, 24/19, 32/19, 46/19, 18/18, 23/18, 39/18, 31/17, 10/16, 28/16, 40/16, 45/16, 7/15, 19/14, 33/14, 37/14, 38/14, 36/13, 44/13, 5/11, 12/11, 15/11, 20/11, 30/11, 9/10, 41/10, 48/10, 16/9, 34/9, 13/8, 1/7, 8/7, 35/7, 0/6, 6/6, 22/6, 29/6, 21/5, 26/5, 42/5, 14/4, 27/4, 47/4, 25/3, 4/1, 11/1, 17/1, 43/1, 49/0]