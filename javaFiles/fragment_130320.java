<% if( request.getParameter( "to" ) == null ) { %>
    <p>
        Click 'Execute' to begin processing.
    </p>
    <form>

        <input type="submit" value="Execute" name="to" />
    </form>
<% } else { %>
    <p>
        Processing...
    </p>
    <pre>
        <%
            PrintStream sysout = System.out;
            try {
                File syncFile = File.createTempFile( "Sync", ".tmp" );

                PrintStream syncOs= new PrintStream( syncFile );
                System.setOut( syncOs );
                String[] myArgs = ...; // set up your args
                Sync.main( myArgs );
                // ... do whatever else you need to do
                syncOs.close();
                syncFile.close();

                FileReader syncRdr = new FileReader( syncFile );
                String line = null;
                while( ( line = syncRdr.readLine() ) {
                    out.println( line );
                }
                syncRdr.close();
                syncFile.delete();
            } catch( Exception ex ) {
                out.print( ex );
            } finally {
                System.setOut( sysout );
            }
        %>
    </pre>
<% } %>