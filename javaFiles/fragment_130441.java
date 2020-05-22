VaadinSession.getCurrent().addRequestHandler(
        new RequestHandler() {
            @Override
            public boolean handleRequest ( VaadinSession session ,
                                           VaadinRequest request ,
                                           VaadinResponse response )
                    throws IOException {
                if ( "/panel.html".equals( request.getPathInfo() ) ) {
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