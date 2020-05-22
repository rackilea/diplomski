for (String QT : Q_T) {
        try {
            // some logic 
        } catch (JsonParseException e) {                    
            LOG.log(Level.SEVERE, "context", e);
        } catch (JsonMappingException e) {
            LOG.log(Level.SEVERE, "context", e);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "context", e);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "context", e);
        }
}