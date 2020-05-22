@GET
@Transactional
@Path( "/threaddump" )
public Response threadDump() throws Exception {
    dumpThreads();
    return Response.ok().build();
}

public static void dumpThreads() throws Exception {
    ProcessBuilder processBuilder = new ProcessBuilder( "/bin/sh", "-c", "kill -3 $PPID" );
    processBuilder.redirectErrorStream( true );
    Process process = processBuilder.start();
    InputStream inputStream = process.getInputStream();
    StreamUtils.copy( inputStream, System.out );
}