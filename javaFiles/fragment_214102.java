ArrayList<String> dayCountList = new ArrayList<String>();
.
.
double day[]=new double[dayCountList.size()];

// now use your loop like this
for (int i = 0; i < dayCountList.size() ; i++) {
               day[i] = Double.parseDouble(dayCountList.get(i));
           }