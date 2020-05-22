public void showDamagedPanels(int dest, int mask) {

    int noOfColours = pickedPanels.size();
    if (noOfColours > 0) {
        ImageView img = (ImageView) findViewById (mask);
        img.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);

        int [] reds = new int[noOfColours];
        int [] greens = new int[noOfColours];
        int [] blues = new int[noOfColours];

        for (int i = 0; i< noOfColours; i++){
            int colour = pickedPanels.get(i);
            reds[i] = (colour >> 16) & 0xFF;
            greens[i] = (colour >> 8) & 0xFF;
            blues[i] = (colour >> 0) & 0xFF;
        }

        final RenderScript rs = RenderScript.create(this);
        final Allocation input = Allocation.createFromBitmap(rs, bitmap, Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptC_singlesource script = new ScriptC_singlesource(rs);

        Allocation red = Allocation.createSized(rs, Element.I32(rs), reds.length);
        red.copyFrom(reds);
        script.bind_reds(red);

        Allocation green = Allocation.createSized(rs, Element.I32(rs), greens.length);
        green.copyFrom(greens);
        script.bind_greens(green);

        Allocation blue = Allocation.createSized(rs, Element.I32(rs), blues.length);
        blue.copyFrom(blues);
        script.bind_blues(blue);

        script.set_imgWidth(pickedPanels.size());
        script.forEach_root(input, output);
        output.copyTo(bitmap);

        ImageView destim = (ImageView) findViewById (dest);
        destim.setDrawingCacheEnabled(true);
        destim.setImageBitmap(bitmap);
    } else {
        ImageView destim = (ImageView) findViewById (dest);
        destim.setImageBitmap(null);
    }


}