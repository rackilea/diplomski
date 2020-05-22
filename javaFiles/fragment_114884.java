public String testSO(AS400 system, String programName) {
    boolean success = false;
    final int ONE_ROW_LEN = 147;
    final int DS_ROWS = 64;
    AS400Text dsText = new AS400Text(ONE_ROW_LEN * DS_ROWS);
    AS400Text p0000g = new AS400Text(20);
    AS400Text p0000h = new AS400Text(10);
    AS400Text p0000i = new AS400Text(10);
    AS400Text p0000j = new AS400Text(20);
    int p0000k;  // packed(9, 0) is 5 bytes
    AS400Text p0000l = new AS400Text( 1);
    AS400Text p0000m = new AS400Text(20);
    AS400Text p0000n = new AS400Text(10);
    AS400Text p0000o = new AS400Text(10);
    AS400Text p0000p = new AS400Text(20);
    AS400Text p0000q = new AS400Text(10);
    AS400Text p0000r = new AS400Text( 1);
    AS400Text p0000s = new AS400Text(10);
    String ds = null;

    String returnString = null;

    try
    {
        ProgramCall program = new ProgramCall(system);

        // Set up the parameter list
        ProgramParameter[] parameterList = new ProgramParameter[1];
        parameterList[0] = new ProgramParameter(ONE_ROW_LEN * DS_ROWS); 
        program.setProgram(programName, parameterList);
        success = program.run();

        if(success!=true){
            AS400Message[] messagelist = program.getMessageList();
            System.out.println("\nMessages received:\n");
            for (int i = 0; i < messagelist.length; i++) {
                System.out.println(messagelist[i]);
            }
        } else {
            // RPG is returning a giant chunk of memory
            //allBytes = parameterList[0].getOutputData();
            ds = (String)dsText.toObject(parameterList[0].getOutputData());
            System.out.println("ds=" + ds);
            System.out.println("ds len=" + ds.length());

            // Need to index our way into the block of memory
            // zero-based!
            int row = 0;
            int x = row * ONE_ROW_LEN;
            System.out.println("x=" + x);

            // parse out the individual elements for this row
            int len = p0000g.getByteLength();
            String s0000g = ds.substring(x, x+len);
            x += len;
            len = p0000h.getByteLength();
            String s0000h = ds.substring(x, x+len);
            x += len;
            len = p0000i.getByteLength();
            String s0000i = ds.substring(x, x+len);
            x += len;
            len = p0000j.getByteLength();
            String s0000j = ds.substring(x, x+len);

        // this is packed(9, 0)
        x += len;
        len = 5;
        byte[] b0000k = dsText.toBytes(ds.substring(x, x+len));
        BigDecimal d0000k = (BigDecimal)new AS400PackedDecimal(9, 0).toObject(b0000k);
        p0000k = d0000k.intValue();
        String s0000k = d0000k.toString();

            x += len;
            len = p0000l.getByteLength();
            String s0000l = ds.substring(x, x+len);
            x += len;
            len = p0000m.getByteLength();
            String s0000m = ds.substring(x, x+len);
            x += len;
            len = p0000n.getByteLength();
            String s0000n = ds.substring(x, x+len);
            x += len;
            len = p0000o.getByteLength();
            String s0000o = ds.substring(x, x+len);
            x += len;
            len = p0000p.getByteLength();
            String s0000p = ds.substring(x, x+len);
            x += len;
            len = p0000q.getByteLength();
            String s0000q = ds.substring(x, x+len);
            x += len;
            len = p0000r.getByteLength();
            String s0000r = ds.substring(x, x+len);
            x += len;
            len = p0000s.getByteLength();
            String s0000s = ds.substring(x, x+len);


            returnString = s0000s;
            System.out.println("Return=" + returnString);
            System.out.println("g=" + s0000g);
            System.out.println("h=" + s0000h);
            System.out.println("i=" + s0000i);
            System.out.println("i=" + s0000i);
            System.out.println("j=" + s0000j);
            System.out.println("k=" + s0000k);
            System.out.println("l=" + s0000l);
            System.out.println("m=" + s0000m);
            System.out.println("n=" + s0000n);
            System.out.println("o=" + s0000o);
            System.out.println("p=" + s0000p);
            System.out.println("q=" + s0000q);
            System.out.println("r=" + s0000r);
            System.out.println("r=" + s0000s);
        }

    } catch (Exception e) {
        System.out.println("\ne:\n");
        System.out.println(e);
        System.out.println("\nStack trace:\n");
        e.printStackTrace();

    }
    return returnString;
}