for (int i = 1; i < x.length(); i++) { // note the range change
    // using (i,i+1) instead of gives you a single character
    if (Integer.parseInt(x.substring(0, 1)) == (Integer.parseInt(x.substring(i, i+1)))-i) {
        counter++;
    }  
}