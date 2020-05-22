package work.basil.example;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.FinishedEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Route ( "upload" )
public class UploadView extends VerticalLayout
{
    // Constructor
    public UploadView ( )
    {
        this.add( new H1( "Upload" ) );
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload( buffer );  // Connect our server-side `Receiver` implementation to the client-side `Upload` widget.
        upload.addFinishedListener(
                ( FinishedEvent finishedEvent ) -> {  // Event fired when user uses the `Upload` widget on the web page.
                    try (  // Autoclosable interface used in try-with-resources syntax.
                           InputStream inputStream = buffer.getInputStream() ;
                    )
                    {
                        // read the contents of the buffer.
                        // https://www.baeldung.com/convert-input-stream-to-array-of-bytes
                        ByteArrayOutputStream bytesReceived = new ByteArrayOutputStream();
                        int content; // Represents each octet arriving on server from client.
                        while ( ( content = inputStream.read() ) != - 1 )  // The arriving octet is returned to us as an `int` in the range 0 to 255. A value of -1 signals end-of-stream. Blocks until data arrives or stream closes.
                        {
                            bytesReceived.write( content );  // Collect the arriving octets into a `ByteArrayOutputStream`.
                        }
                        // Parse the collected octets as being text in UTF-8 encoding.
                        String s = new String( bytesReceived.toByteArray() , StandardCharsets.UTF_8 );  // You must know the particular  character-encoding used in the file.
                        this.add( new Paragraph( s ) );  // Echo the file contents back to the user.
                        System.out.println( "s = " + s );
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                }
        );
        this.add( upload );  // Make the `Upload` instance named `upload` appear on our Vaadin-produced web page.
    }
}