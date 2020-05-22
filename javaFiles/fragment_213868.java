/**
     * write the object to a file 
     */
    private static void writeToFile( Serializable s , String fileName ) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream( new FileOutputStream( new File( fileName )));
            oos.writeObject( s );    
        } catch( IOException ioe ){

        } finally {
            if( oos != null ) try {
                oos.close();
            } catch( IOException ioe ){}
        }

    }
    /**
     * Read an object from the file 
     */
    private static Object readObjectFrom( File f ) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream( f )) ;
            return ois.readObject();
        } catch( ClassNotFoundException cnfe ){
            return null;
        } catch( IOException ioe ) {
            return null;
        } finally {
            if( ois != null ) try {
                ois.close();
            } catch( IOException ioe ){}
        }
    }
}