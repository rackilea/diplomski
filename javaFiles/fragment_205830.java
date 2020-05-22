ArrayList<String> cityNames = [...];

String cities = "";
for(String city : cityNames)
    cities += ", " + city; //or use "<br>" for separate lines
cities = cities.substring(2); //remove the first ", "

JLabel cityLabel = new JLabel(cities); //add this to your rendering panel