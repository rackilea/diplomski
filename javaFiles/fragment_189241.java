long num = 600851475143L;
List<Long> factors = new ArrayList<Long>(); // or use a Set
if (num & 1 == 0) {
  factors.add(2L);
}
for (long i=3; i*i<=num; i+=2) {
  // first check i is prime
  // if i is prime check if it is a factor of num
}