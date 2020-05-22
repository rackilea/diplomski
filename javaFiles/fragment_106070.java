private boolean isWSDLAvailable(String wsdlAddr) {
            HttpURLConnection c = null;
            try {
                URL u = new URL(wsdlAddr);
                c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("HEAD");
                c.getInputStream();
                return c.getResponseCode() == 200;
            } catch (Exception e) {
                return false;
            } finally {
                if (c != null) c.disconnect();
            }    
    }