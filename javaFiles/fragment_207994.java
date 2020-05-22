private Typeface myFont;


public myConstructor() {  
    /* ... */  
    Typeface GC = Typeface.createFromAsset(getAssets(),"fonts/ADarling.ttf");  
    myFont = Typeface.create(GC, Typeface.NORMAL);
    /* ... */  
}

void drawText2(Canvas c)
    /* ... */  
    paint.setTypeface(myFont);
    /* ... */
}