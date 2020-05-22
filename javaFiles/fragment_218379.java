double rulesfpadouble = 3.9191070819954144E14;
String[] too = String.valueOf(rulesfpadouble).replaceAll("\\D", "").split(""); 
int[] remainders = new int[too.length];

for (int i = 0; i < too.length; i++){
    remainders[i] = (Integer.parseInt(too[i]) % 2);        
}

System.out.println(Arrays.toString(remainders));