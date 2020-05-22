// make a single pass over oracle rows, so O(n)
Set<String> oracleLower = new HashSet<>();
for(String or : oracleTable.getRows()) {
    oracleLower.add(or.toLowerCase());
}

// make a single pass over msft rows, so O(n)
Set<String> msftLower = new HashSet<>();
for(String ms : microsoftTable.getRows()) {
    msftLower.add(ms.toLowerCase());
}

// make a single pass over oracle rows, again O(n)
for(String or : oracleLower) {
    // backed by a hash table, this has a constant time lookup
    if(!msftLower.contains(or)) {
        unmatched.add(or);
    }
}