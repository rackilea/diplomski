// be careful of bounds of the indexes    
for (int i = 1; i< s.length() - 1; i++) {
    if ((s.charAt(i) == '*')) {
            if ((s.charAt(i-1)) == s.charAt(i+1)) {
                ind = "SAME";
            } else {
                ind = "DIFFERENT";
                break;
            }
        }
    }
    System.out.print(ind);