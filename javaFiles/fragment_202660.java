public String getPassword(){
      SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
      byte[] salt = new byte[16];
      sr.nextBytes(salt);

      return wellformedPassword(salt.toString()) ? salt.toString() : secured(salt.toString());

   }

   public String secured(String pass){
       return string1.replaceFirst(Pattern.quote("[a-z]", "Z");
   }

   public boolean wellformedPassword(String pass){
      return checkRegExp(pass, "\\d") 
              && checkRegExp(pass, "[A-Z]")
              && checkRegExp(pass, "[a-z]");
   }

   public boolean checkRegExp(String str, String pattern){
      Pattern p = Pattern.compile(pattern);
      Matcher n = p.matcher(str);
      return n.find();
   }