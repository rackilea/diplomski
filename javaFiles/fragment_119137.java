public class IOTest {

    public static void main(String[] args) {

        File file;

        // create your Tree
        DirectoryTree dirTree;
        file = new File("filename");
        dirTree = createTree();

        // write object into file
        writeTree( dirTree, file );

        // read object from file
        DirectoryTree newDirTree;
        file = new File("filename");
        newDirTree = readTree( file );

    }

    public static DirectoryTree createTree() {

       // create here your tree

    }

    public static void writeTree( DirectoryTree tree, File file ) {

       FileOutputStream fos;
       ObjectOutputStream oos;

       try { 
           fos = new FileOutputStream( file );
           oos = new ObjectOutputStream( fos );

           oos.writeObject( tree );
           oos.flush();

           oos.close();
       } catch( IOException ioe ) {
           ioe.printStackTrace();
       }

    }

    public static DirectoryTree readTree( File file ) {

       DirectoryTree loadedTree = null;
       FileInputStream fos;
       ObjectInputStream oos;

       try { 
           fos = new FileInputStream( file );
           oos = new ObjectInputStream( fos );


           // you have to cast your object into a DirectoryTree,
           // because read() will return an object of type `Object`
           loadedTree = (DirectoryTree) oos.read();

           oos.close();
       } catch( IOException ioe ) {
           ioe.printStackTrace();
       }

       return loadedTree;

    }

}