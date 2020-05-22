// Initialize the map for Morse code lookup
Map<String, Character> lookup = new HashMap<>();
for (int i=0; i<codes.length; i++) lookup.put(codes[i], letters[i]);

// Build the result string by looking up each Morse code segment in the map
StringBuilder result = new StringBuilder();
for (int i=0; i<parts.length; i++) result.append(lookup.get(parts[i]));
System.out.println(result);