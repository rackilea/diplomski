String country = f[0];
String date = f[4];
String year = date.split("-")[2];    
if (country.equals("Afghanistan") && year.equals("2010")) {
    a[count] = Integer.parseInt(f[2]);
    sum += a[count];
    count++;
}