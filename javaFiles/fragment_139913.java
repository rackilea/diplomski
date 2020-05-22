String norwegian = "< a, \u00E5;A< b,B< c,C< d,D< e,E< f,F< g,G< h,H< i,I< j,J" +
                   "< k,K< l,L< m,M< n,N< o,O< p,P< q,Q< r,R< s,S< t,T" +
                   "< u,U< v,V< w,W< x,X< y,Y< z,Z";                      
RuleBasedCollator myNorwegian = new RuleBasedCollator(norwegian);     
List<String> words = 
  Arrays.asList("Arendal Bergen Drammen \u00E5lesund".split("\\s"));     
System.out.println(words);     
Collections.sort(words, myNorwegian);     
System.out.println(words);