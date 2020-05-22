public class testBed{


    public static void callRepoImages() throws FindFailed {
        ReporImages();
    }


@Test       
public static void ReporImages() {
    ImagesRepo imgrepo = new ImagesRepo();
    imgrepo.imageRepoApp();   //So that pattern assignment is done.
    Screen screen = new Screen();
    screen.click(imgrepo.imgBtn01); //the imgBtn01 has a redline
    screen.click(imgrepo.imgBtn02); //the imgBtn02 has a redline
    return;

}
}