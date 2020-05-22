JSONArray lines = geometry.getJSONArray("coordinates");
        double[][] coords = new double[lines.length()][];
        for (int i = 0; i < lines.length(); i++) {
            JSONArray xyJson = lines.getJSONArray(i);
            coords[i] = new double[xyJson.length()];   // length is always 2
            for (int j = 0; j < xyJson.length(); j++) {
                coords[i][j] = xyJson.getDouble(j);
            }
        }