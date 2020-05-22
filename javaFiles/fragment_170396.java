StringBuilder output = new StringBuilder();
char[] input = text.toCharArray();
int braceLevel = 0;
for (int i = 0; i < input.length; i++) {
   final char c = input[i];
   if (c == '{') {
      // Check for {{
      if (i < input.length - 1 && input[i+1] == '{') {
         // Yep, it's a double brace - increase the level, consume
         // the second character and continue with the next char
         braceLevel++;
         i++;
         continue;
      }
   }
   else if (c == '}' && braceLevel > 0) {
      // Check for a closing brace similar to above
      if (i < input.length - 1 && input[i+1] == '}') {
         braceLevel--;
         i++;
         continue;
      }
   }

   if (braceLevel == 0) {
      output.append(c);
   }
}

// Now output contains every character that was not contained within brackets