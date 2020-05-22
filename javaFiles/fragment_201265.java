public class House
{
    String owner;
    Picture [] picArray;
    Picture favPic;

    public void setFavoritePicture ()
    {
        Picture pic  = new Picture (FileChooser.pickAFile ());
        this.favPic = pic;
    }

    ... /* Rest of your class here */

    public static void main (String [] args)
    {
        House PhDsHouse = new House ("Mad PH.D.");
        PhDsHouse.setFavoritePicture();
    }
}