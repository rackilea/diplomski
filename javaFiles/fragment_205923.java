private static final String seasons[] = {
  "Winter", "Winter", "Spring", "Spring", "Summer", "Summer", 
  "Summer", "Summer", "Fall", "Fall", "Winter", "Winter"
};
public String getSeason( Date date ) {
   return seasons[ date.getMonth() ];
}

// As stated above, getMonth() is deprecated, but if you start with a Date, 
// you'd have to convert to Calendar before continuing with new Java, 
// and that's not fast.