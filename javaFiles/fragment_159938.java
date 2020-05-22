try {

               AS400 sys = new AS400("");
    SpooledFile sf = new SpooledFile( sys,          // AS400
                                        "CUSR_R1",       // splf name
                                        2,           // splf number
                                        "QPADEV003H",    // job name
                                        "USER",      // job user
                                        "096018" );   // job number

PrintParameterList printParms = new PrintParameterList();
printParms.setParameter(PrintObject.ATTR_WORKSTATION_CUST_OBJECT,   "/QSYS.LIB/QWPDEFAULT.WSCST");
printParms.setParameter(PrintObject.ATTR_MFGTYPE, "*WSCST");

// Create a page input stream from the spooled file
PrintObjectPageInputStream is = sf.getPageInputStream(printParms);

BufferedReader d = new BufferedReader(new InputStreamReader(is));
       String data ="";
       while((data = d.readLine() )!=null)
       {
        System.out.println (data);
        }
    } catch (Exception e) {
        System.out.println(e);
    }

}