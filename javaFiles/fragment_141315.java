List<String> A = Arrays.asList("a", "bnbnb");
List<String> B = Arrays.asList("1", "2", "3");

// you have to do this in two steps:
List<String> C = new ArrayList<String>(Arrays.asList("x"));
C.addAll(A);

// iteration:
for (List<String> x : Arrays.asList(A, B, C)) {
    // do something to x.get(0), analogous to x[0] in Python    
}