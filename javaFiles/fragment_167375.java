float xAxis = convertPixel2Point(/*signProperties.getX()*/x) ;
float yAxis = convertPixel2Point(/*signProperties.getY()*/y);               
float signImageHeight = convertPixel2Point(/*signImageHeight*/324);    
float signImageWidth = convertPixel2Point(/*signImageWidth*/309);

int rotation = getPageRotation(inputFilePath, page) % 360;
switch (rotation)
{
case 0:
    // all ok;
    break;
case 90:
    visibleSig.affineTransformParams(new byte[] {0, 1, -2, 0, 100, 0})
              .formaterRectangleParams(new byte[]{0, 0, 100, 100});

    float temp = yAxis;
    yAxis = visibleSig.getPageHeight() - xAxis - signImageWidth;
    xAxis = temp;

    temp = signImageHeight;
    signImageHeight = signImageWidth;
    signImageWidth = temp;

    break;
case 180:
    // Implement in a similar fashion
case 270:
    // Implement in a similar fashion
}

visibleSig.xAxis(xAxis)
          .yAxis(yAxis)
          .zoom(0)
          .signatureFieldName("Signature")
          .height(signImageHeight)
          .width(signImageWidth);