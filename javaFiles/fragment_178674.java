if( s.length() < t.length() ){
     String h = s; s = t; t = h;
 }
 // now s is not shorter than t
 int max = s.length();
 int min = t.length();
 StringBuilder a = new StringBuilder(s);
 StringBuilder b = new StringBuilder(t);