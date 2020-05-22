Bitmap DevImjBmpFrmTxtFnc(String TxtSrgPsgVal)
{
    int TxtSyzVal = 100;
    TextPaint PenPytVaj = new TextPaint(ANTI_ALIAS_FLAG);
    PenPytVaj.setTextSize(TxtSyzVal);
    PenPytVaj.setColor(Color.BLACK);
    PenPytVaj.setTextAlign(Paint.Align.LEFT);

    Rect TxtRctVar = new Rect();
    PenPytVaj.getTextBounds(TxtSrgPsgVal, 0, TxtSrgPsgVal.length(), TxtRctVar);
    Bitmap TxtImjBmpVar = Bitmap.createBitmap(TxtSyzVal * 2, TxtSyzVal * 2, Bitmap.Config.ARGB_8888);

    Canvas ImjCanvasVaj = new Canvas(TxtImjBmpVar);
    float XcoVal = ImjCanvasVaj.getWidth() / 2 - TxtRctVar.width() / 2  - TxtRctVar.left;
    float YcoVal = ImjCanvasVaj.getHeight() / 2 + TxtRctVar.height() / 2  - TxtRctVar.bottom;
    ImjCanvasVaj.drawText(TxtSrgPsgVal, XcoVal, YcoVal, PenPytVaj);
    return TxtImjBmpVar;
}