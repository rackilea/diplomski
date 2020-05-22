// Breadth first returns null if not found
  public String bruteforce(List<String> prefixes, String md5,int availdepth) {
    if(availabledepth<0) return null;
    List<String> newprefixes = new ArrayList<String>();
    for(String prefix : prefixes) {
        for (char c = ' '; c < '~'; ++c) {
          String attempt = prefix + Character.toString(c);
          generatedMd5 = generateMD5(attempt);
          if (hashesMatch(md5, generatedMd5)) 
            return attempt;
          newprefixes.add(attempt);
       }
    }
    // no success in this level go for next
    return bruteforce(newprefixes,md5,availddepth-1);
  }


  // Depth first - returns null if not found
  public String bruteforce(String prefix, String md5,int availdepth) {
    if(availdepth <= 0) return null;
    for (char c = ' '; c < '~'; ++c) {
          String attempt = prefix + Character.toString(c);
          if (hashesMatch(md5, generateMD5(attempt))) 
            return attempt;
          String res = bruteforce(attempt, md5, availdepth-1);
          if(res != null) return res;
       }
    return null;
  }