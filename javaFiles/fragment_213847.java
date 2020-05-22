@Override
public ServletOutputStream getOutputStream() 
{ 
    if (outpstrm == null) outpstrm = new AppServletOutputStream(output);
    return outpstrm;
} 
@Override
public PrintWriter getWriter() 
{ 
    if (pwriter == null) pwriter = new PrintWriter(getOutputStream(),true); 
    return pwriter;
}