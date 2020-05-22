String selectedCities = "Miami"; // Selected(Predefine) city
int count = 0;
int city = 0;
String finall = "California,Miami,Delawar,New Jursey";
String[] separated = finall.split(",");
count = separated.length; // find total city in array

for (int i = 0; i < count; ++i){
    if (selectedCities.equals(separated[i])){
        city = 1;
    }
}
System.out.println("City Count = "+city); //Here count will be 1