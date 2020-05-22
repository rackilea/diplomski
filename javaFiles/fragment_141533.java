Random acak = new Random ();
int max = 99;
int []hasilRandom = new int[9];
StringBuilder text = new StringBuilder();
for (int i = 0; i <hasilRandom.length; i++){
    hasilRandom[i] = acak.nextInt(max);
    text.append(hasilRandom[i]+", ");
}
jTextRandom.setText(text.toString());