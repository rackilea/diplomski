String sXML = r.readEntity(byte[].class);
// check for gzip encoding using signature
if(sXML.length > 3 && 
   sXML[0] == (byte)0x1F && 
   sXML[1] == (byte)0x8B && 
   sXML[2] == (byte)0x08) {
    // Is gzip encoded, decode it.
    return new String(decompress(sXML), "UTF-8");
} else {
    return new String(sXML, "UTF-8");
}