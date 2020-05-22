largest = smallest = s.substring(0, k);
for (int i = 1; i <= s.length() - k; i++) {
    if (s.charAt(i) > largest.charAt(0) ){
      largest = s.substring(i, i + k);
      continue;
    }
    if (s.charAt(i) < smallest.charAt(0) ){
      smallest = s.substring(i, i + k);
      continue;
    }

    if (s.charAt(i) == largest.charAt(0) ){
        String temp = s.substring(i, i + k);
        if( temp.compareTo(largest) > 0) {
            largest = temp;
            continue;
        }
    }
    if (s.charAt(i) == smallest.charAt(0) ){
        String temp = s.substring(i, i + k);
        if( temp.compareTo(smallest) < 0) {
            smallest = temp;
        }
    }
}