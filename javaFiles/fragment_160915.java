% Do all the imports
% sql query to get the data
dataStream    = ByteArrayInputStream( decodeBase64( rows.data{1} ) );
bufferedImage = ImageIO.read( dataStream );
[w h] = deal( theWidth, theHeight );
imageData     = uint8( bufferedImage.getData.getPixels( 0,0,w,h,[] ) );
imageData     = permute( reshape( imageData, [3 w h] ), [2 3 1] );

imshow( imageData );
% voila