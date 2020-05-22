String[] tokens = s.split(",");
double[] result = new double[tokens.length];
int i = 0; // This is used for putting each double in the array
for(String token:tokens) {
    result[i++] = Double.parseDouble(token);
}