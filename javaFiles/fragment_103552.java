//add values to dataset
double Time = Double.valueOf(readNextLine[0]);
double X = Double.valueOf(readNextLine[1]);
double Y = Double.valueOf(readNextLine[2]);    
double Z = Double.valueOf(readNextLine[3]);
seriesX.add(Time, X);
seriesY.add(Time, Y);
seriesZ.add(Time, Z);