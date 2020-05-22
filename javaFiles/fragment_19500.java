float v = 23.51F;
DecimalFormat df = new DecimalFormat("#");
df.setMaximumFractionDigits(8);
char[] d = df.format(v).toCharArray();
int count = 0;
for (int i = 0 ; i != d.length ; i++) {
    if (Character.isDigit(d[i])) {
        count++;
    }
}
int[] res = new int[count];
int pos = 0;
for (int i = 0 ; i != d.length ; i++) {
    if (Character.isDigit(d[i])) {
        res[pos++] = Character.digit(d[i], 10);
    }
}