package work.basil.example ;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.FinishedEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@PreserveOnRefresh
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
                        // Read the data arriving in the buffer via the `InputStream` to produce a `String` object.
                        String s = IOUtils.toString( inputStream , StandardCharsets.UTF_8 );
                        this.add( new Paragraph( s ) );
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