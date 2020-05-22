Set<Integer> used = new HashSet<Integer>();

// wrap this code-block in some method...
Integer num;
do {
   num = random.nextInt(10);
   if (!used.contains(num)) {
      used.add(num);
      break;
   }
} while(used.size() < 10);