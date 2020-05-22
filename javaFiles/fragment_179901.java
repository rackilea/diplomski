String[] colorsTxt = getApplicationContext().getResources().getStringArray(R.array.colors);
List<Integer> colors = new ArrayList<Integer>();
for (int i = 0; i < colorsTxt.length; i++) {
    int newColor = Color.parseColor(colorsTxt[i]);
    colors.add(newColor);
}