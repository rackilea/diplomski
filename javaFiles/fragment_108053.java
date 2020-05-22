Record[] records = null;// = new Record[0];
        try {
            Lookup configLookup = new Lookup(query_url, Type.SRV);
            configLookup.setResolver(new ExtendedResolver()); /** FIX **/
            records = configLookup.run();
        } catch (TextParseException e) {
            e.printStackTrace();
            return null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }