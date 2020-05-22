RenderedImage image = getMyImage();         
Iterator<ImageWriter> iterator = ImageIO.getImageWritersBySuffix( "png" );

if(!iterator.hasNext()) throw new Error( "No image writer for PNG" );

ImageWriter imagewriter = iterator.next();
ByteArrayOutputStream bytes = new ByteArrayOutputStream();
imagewriter.setOutput( ImageIO.createImageOutputStream( bytes ) ); 

// Create & populate metadata
PNGMetadata metadata = new PNGMetadata();
// see http://www.w3.org/TR/PNG-Chunks.html#C.tEXt for standardized keywords
metadata.tEXt_keyword.add( "Title" );
metadata.tEXt_text.add( "Mandelbrot" );
metadata.tEXt_keyword.add( "Comment" );
metadata.tEXt_text.add( "..." );
metadata.tEXt_keyword.add( "MandelbrotCoords" ); // custom keyword
metadata.tEXt_text.add( fractal.getCoords().toString() );           

// Render the PNG to memory
IIOImage iioImage = new IIOImage( image, null, null );
iioImage.setMetadata( metadata ); // Attach the metadata
imagewriter.write( null, iioImage, null );