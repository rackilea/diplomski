private Map<Double, Byte> mapNormalOutCurrVals(){

Map map = new HashMap();
double x = 0.000;
byte i = 0;

//first set of normal output currents
while (x <= 2.000){
    map.put(new Double(x), new Byte(i));
    x += 0.125;
    i++;
}

while (x <= 4.000){
    map.put(new Double(x), new Byte(i));
    x += 0.250;
    i++;
}

while (x <= 8.000){
    map.put(new Double(x), new Byte(i));
    x += 0.500;
    i++;
}

return map;
}