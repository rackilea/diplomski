while (true)
{
    try{
        Socket temp = s.accept();
        sock = temp;
        executor.execute(new FileHandler(sock));
        // serveFile(temp) ;
    }catch(SocketException ex){
        doAcleanShutdown();
    }
}