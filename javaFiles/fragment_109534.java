private byte[] encode(YourObject obj)
    {
        byte[] bytes = null;
        try
        {
            YourObject vsNew = new YourObject(obj)
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                GZIPOutputStream out = new GZIPOutputStream(baos);
                XMLEncoder encoder = new XMLEncoder(out);
                encoder.writeObject(vsNew);
                encoder.close();
                bytes = baos.toByteArray();
        }
        catch (Exception e)
        {
            _log.error("Exception caught while encoding/zipping ", e);
        }
        return bytes;
    }


    /*
     * Decode the report definition blob back to the
     * ScheduledReport object.
     */
    private YourObject decode(byte[] bytes)
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        YourObject vSNew = null;
        try
        {
            GZIPInputStream in = new GZIPInputStream(bais);
            XMLDecoder decoder = new XMLDecoder(in);
            vSNew = (YourObject)decoder.readObject();
            decoder.close();
        }
        catch (Exception e)
        {
            _log.error("IOException caught while decoding/unzipping ", e);
        }
        return vSNew ;
    }