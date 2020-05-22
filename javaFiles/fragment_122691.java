arrayI = new POJO_I [response.body().length];
int counter = 0;
arrayI = response.body();
arrayOfNamesMain = new String[10];

for(int t = 0; t< arrayI.length; t++) {
    if (arrayI[t].getMain().equals("1")) {
        arrayOfNamesMain[counter] = arrayI[t].getName();
        counter++;
    }
}