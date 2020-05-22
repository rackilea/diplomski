String[] vals = new String[3];
vals[0] = "Apple";
vals[1] = null;
vals[2] = "Banana";

String a[] = fitlerNullString(vals);

for(int j = 0; j < a.length; j++){
    System.out.print(a[j] + "\t");
}