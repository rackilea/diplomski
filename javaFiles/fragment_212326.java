String str = "I am hulli";
String[] parts = str.split(" ");
StringBuilder result = new StringBuilder(parts[parts.length - 1]);

// Assume there's at least one world in str
result.append(parts[parts.length - 1]); 
for (int i = parts.length - 2; i >= 0; --i) {
    result.append(" ").append(parts[i]);
}
System.out.println(result);