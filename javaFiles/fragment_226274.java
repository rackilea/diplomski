public void loadShapePoints () {
    BufferedReader reader = null;
    float height = drawView.getCanvasHeight();
    float width = drawView.getCanvasWidth();
    float tmp = 0;
    try {
        reader = new BufferedReader(new InputStreamReader(getAssets().open(protocol+cornice)));
        String mLine;
        for (int elem=0; (mLine = reader.readLine()) != null; elem++) {
            mLine = mLine.replaceAll("\\s+","");
            if (elem%2==0) {
                tmp = Float.parseFloat(mLine);
            } else {
                float x = (width/2540)*(Float.valueOf(tmp));
                float y = (height/1109)*(Float.valueOf(Float.parseFloat(mLine)));
                Pair p1 = new Pair(x, y);
                points.add(p1);
            }
        }
    } catch (IOException e) { } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) { }
        }
    }
    drawView.setShape(points);
}