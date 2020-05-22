PDPageContentStream contents = new PDPageContentStream(doc, page, AppendMode.APPEND, true);

//float[] fTx = { 100, 100, 500, 340 };
//float[] fTy = { 500, 700, 700, 300 };
float[] fTx = { 100, 100, 500, 500 };
float[] fTy = { 500, 700, 700, 500 };
Color[] cArray = { Color.BLUE, Color.RED, Color.ORANGE, Color.MAGENTA };

int[] tAngles = { 0, -90, 180, 90 }; /* in degree */
/* in degree */
int angle;
//int previousAngle = 0;

/*  */
contents.addRect(100, 500, 400, 200);
contents.stroke();

for (int i = 1; i <= 4; i++)
{
    contents.saveGraphicsState();
    /* transform */
    contents.transform(Matrix.getTranslateInstance(fTx[i - 1], fTy[i - 1]));
    contents.transform(Matrix.getRotateInstance(Math.toRadians(tAngles[i - 1] /* - previousAngle */), 0, 0));
    //TH not needed previousAngle = tAngles[i - 1];
    contents.transform(Matrix.getTranslateInstance(-fTx[i - 1], -fTy[i - 1]));

    /* Shapes */
    contents.setNonStrokingColor(cArray[i - 1]);
    contents.addRect(fTx[i - 1], fTy[i - 1], 100, 20);
    contents.fillAndStroke();

    contents.setNonStrokingColor(Color.GREEN);
    contents.addRect(fTx[i - 1], fTy[i - 1], 5, 5);
    contents.fillAndStroke();
    contents.restoreGraphicsState();

}