package com.basilbourque.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme ( "mytheme" )
public class MyUI extends UI {

    @Override
    protected void init ( VaadinRequest vaadinRequest ) {
        final VerticalLayout layout = new VerticalLayout();

        TextField personUuid = new TextField( "UUID of Person:" );
        personUuid.setWidth( 22 , Unit.EM );
        personUuid.setValue( UUID.randomUUID().toString() );
        personUuid.setReadOnly( true );

        Button webPageButton = new Button( "Generate Person report" );
        webPageButton.setWidthUndefined();
        webPageButton.addClickListener( e -> {
            System.out.println( "Button clicked. " + ZonedDateTime.now() );
        } );

        // Configure web page opener object. Must be done *before* user clicks on button, not after.
        String servletPath = VaadinServlet.getCurrent().getServletContext().getContextPath(); // URL for this web app at runtime.
        Resource resource = new ExternalResource( servletPath + "/person.html" );  // Defining an external resource as a URL that is not really so external -- will call back into this same web app.
        BrowserWindowOpener webPageOpener = new BrowserWindowOpener( resource );
        webPageOpener.setWindowName( "Person ID: " + personUuid.getValue() );  // Set title of the new window to be opened.
        String param = "person_id";
        webPageOpener.setParameter( param , personUuid.getValue() );
        String windowFeaturesString = String.format( "width=%d,height=%d,resizable" , Page.getCurrent().getBrowserWindowWidth() , Page.getCurrent().getBrowserWindowHeight() ); // Same size as original window.
        webPageOpener.setFeatures( windowFeaturesString );  // Example: "width=800,height=600,resizable".
        webPageOpener.extend( webPageButton ); // Connect opener with button.
        System.out.println( "TRACE BrowserWindowOpener URL: " + webPageOpener.getUrl() );

        layout.addComponents( personUuid , webPageButton );
        setContent( layout );

        // A request handler for generating some content
        VaadinSession.getCurrent().addRequestHandler(
                new RequestHandler() {
                    @Override
                    public boolean handleRequest ( VaadinSession session ,
                                                   VaadinRequest request ,
                                                   VaadinResponse response )
                            throws IOException {
                        if ( "/person.html".equals( request.getPathInfo() ) ) {
                            // Retrieve the hex-string of the UUID from the URL’s query string parameter.
                            String uuidString = request.getParameter( "person_id" );  // In real-work, validate the results here.
                            UUID uuid = UUID.fromString( uuidString ); // Reconstitute a `UUID` object from that hex-string. In real-work, validate the results here.
                            System.out.println( "UUID object reconstituted from string passed as parameter in query string of URL opened in new window: " + uuid );
                            // Build HTML.
                            String html = renderHtml( uuid );
                            // Send out the generated text as HTML, in UTF-8 character encoding.
                            response.setContentType( "text/html; charset=utf-8" );
                            response.getWriter().append( html );
                            return true; // We wrote a response
                        } else
                            return false; // No response was written
                    }
                } );
    }

    // Generate the HTML to report on the details of a `person` from the database, given the UUID of that database row.
    private String renderHtml ( UUID uuid ) {
        String eol = "\n"; // End-of-line character(s) to use in the HTML.
        StringBuilder html = new StringBuilder();
        html.append( "<!DOCTYPE html>" ).append( eol );
        html.append( "<html>" ).append( eol );
        html.append( "<head>" ).append( eol );
        html.append( "<title>Person</title>" ).append( eol );
        html.append( "</head>" ).append( eol );
        html.append( "<body style='color:DarkSlateGray' >" ).append( eol );
        html.append( "<h1>Demo</h1>" ).append( eol );
        html.append( "<p>This is a drill. This is only a drill.</p>" ).append( eol );
        html.append( "<p>If this had been a real application, you would have seen some data.</p>" ).append( eol );
        html.append( "<p>Person ID: " ).append( uuid.toString() ).append( ".</p>" ).append( eol );
        html.append( "<p style='color:DimGray ; font-family: Pragmata , Hack , Menlo , monospace' >Report generated " ).append( Instant.now() ).append( ".</p>" ).append( eol );
        html.append( "</body>" ).append( eol );
        html.append( "</html>" ).append( eol );
        String s = html.toString();
        System.out.println( "\n\n" + s + "\n\n" );
        return s;
    }

    @WebServlet ( urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true )
    @VaadinServletConfiguration ( ui = MyUI.class, productionMode = false )
    public static class MyUIServlet extends VaadinServlet {
    }
}