public class DVDApplication extends ArrayListDVDCollection{
    public static void main (String[] args){
        ArrayList<DVD> DVDArrayList = new ArrayList<DVD>();
        File dvdData = new File ("DVDCollection.txt");
        DVDApplication dvdapp = new DVDApplication ();
        DVDArrayList = dvdapp.loadData (dvdData);
    }
}