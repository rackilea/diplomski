BufferedReader br = new BufferedReader (new FileReader (oldpem_file));
    StringBuilder b64 = null;
    String line;
    while( (line = br.readLine()) != null )
        if( line.equals("-----BEGIN RSA PRIVATE KEY-----") )
            b64 = new StringBuilder ();
        else if( line.equals("-----END RSA PRIVATE KEY-----" ) )
            break;
        else if( b64 != null ) b64.append(line);
    br.close();
    if( b64 == null || line == null ) 
        throw new Exception ("didn't find RSA PRIVATE KEY block in input");

    // b64 now contains the base64 "body" of the PEM-PKCS#1 file
    byte[] oldder = Base64.decode (b64.toString().toCharArray());

    // concatenate the mostly-fixed prefix plus the PKCS#1 data 
    final byte[] prefix = {0x30,(byte)0x82,0,0, 2,1,0, // SEQUENCE(lenTBD) and version INTEGER 
            0x30,0x0d, 6,9,0x2a,(byte)0x86,0x48,(byte)0x86,(byte)0xf7,0x0d,1,1,1, 5,0, // AlgID for rsaEncryption,NULL
            4,(byte)0x82,0,0 }; // OCTETSTRING(lenTBD) 
    byte[] newder = new byte [prefix.length + oldder.length];
    System.arraycopy (prefix,0, newder,0, prefix.length);
    System.arraycopy (oldder,0, newder,prefix.length, oldder.length);
    // and patch the (variable) lengths to be correct
    int len = oldder.length, loc = prefix.length-2; 
    newder[loc] = (byte)(len>>8); newder[loc+1] = (byte)len;
    len = newder.length-4; loc = 2;
    newder[loc] = (byte)(len>>8); newder[loc+1] = (byte)len;

    FileOutputStream fo = new FileOutputStream (newder_file);
    fo.write (newder); fo.close();
    System.out.println ("converted length " + newder.length);