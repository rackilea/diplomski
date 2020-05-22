String[] strs = { "str1", "str2", "str3", "str4", "str5" };

// Select a random (valid) index of the array strs
Random rnd = new Random();
int index = rnd.nextInt(strs.length);

// Print the randomly selected string
System.out.println(strs[index]);