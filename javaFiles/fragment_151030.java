// Inelegant version
if (!hs.contains(T1)) {
    hs.add(T1);
    mainarray.put(T1);
}

// Elegant version that avoids two probes of the hashset
// ... see javadocs for `Set.add` to understand why this works.
if (hs.add(T1)) {
    mainarray.put(T1);
}