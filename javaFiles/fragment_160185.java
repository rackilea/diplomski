ArrayList<Integer> min = new ArrayList<Integer>(5);  
ArrayList<Integer> max = new ArrayList<Integer>(5);  

// ASSUMPTION: s1, s2 and s3 has the same length, or at least s1.length is the 
// shortest list
for (int i = 0; i < s1.length; i++) {
  max.add(Math.max(Math.max(s1.get(i), s2.get(i)), s3,get(i)));
  min.add(Math.min(Math.min(s1.get(i), s2.get(i)), s3,get(i)));
}