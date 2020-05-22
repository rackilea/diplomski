List<String> permutations = new ArrayList<String>(initial size); // initial size to avoid multiple arrays to be created
if (s.length() == 1) {
    permutations.add(s);
} else {
    StringBuffer sb = new StringBuffer(s);
    loop { // some kind of loop
        sb.setCharAt(0, 'a'); // do the next permutation
        permutations.add(sb.toString());
    }
}
return permutations;