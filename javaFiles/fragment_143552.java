SpeedUnit fromSUUnit = null;
SpeedUnit toSUUnit = null;
if(fromUnit !=null && fromUnit.equals("milesPerhour"))
fromSUUnit = SpeedUnit.milesPerhour;
if(toUnit !=null && toUnit.equals("kilometersPerhour"))
toSUUnit = SpeedUnit.kilometersPerhour;
double res = serProxy.convertSpeed(spd,fromSUUnit,toSUUnit);