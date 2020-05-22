String[] elements = s.substring(j+1, k).split(",");
Vector<Double> vector = new Vector<Double>();
for (String element : elements) {
    vector.add(Double.parseDouble(element));
}
matrix.add(vector);