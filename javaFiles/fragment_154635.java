@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    getServletContext().log("entering doPost()");
    TTransport inTransport = null;
    TTransport outTransport = null;
    try {

        InputStream in = request.getInputStream();
        OutputStream out = response.getOutputStream();

        TTransport transport = new TIOStreamTransport(in, out);
        inTransport = transport;
        outTransport = transport;

        TProtocol inProtocol = getInProtocolFactory().getProtocol(inTransport);
        TProtocol outProtocol = getOutProtocolFactory().getProtocol(outTransport);

        if (multiplex.process(inProtocol, outProtocol)) {
            out.flush();
        } else {
            throw new ServletException("multiplex.process() returned false");
        }
    } catch (TException te) {
        throw new ServletException(te);
    } finally {
        if (inTransport != null) {
            inTransport.close();
        }
        if (outTransport != null) {
            outTransport.close();
        }
    }
}