public class Filewalker { 

    public void walk( String path ) { 

        File root = new File( path ); 
        File[] list = root.listFiles(); 

        for ( File f : list ) { 
            if ( f.isDirectory() ) { 
                walk( f.getAbsolutePath() ); 
                System.err.println( "Dir:" + f.getAbsoluteFile() ); 
            } 
            else { 
                System.err.println( "File:" + f.getAbsoluteFile() ); 
            } 
        } 
    } 

    public static void main(String[] args) { 
        Filewalker fw = new Filewalker(); 
        fw.walk("c:\\" ); 
    } 
}