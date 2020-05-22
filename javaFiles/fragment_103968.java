public class Person {

private String FName;
private String LName;
private String Biography;
private Bitmap image; // add the image too to your class, you can store the url of the image 
// or save it using bitmap.. if you store the url then = String image; the load the image
// in the getview method.. any way you choose..
public String getFName() {
    return FName;
}
public void setFName(String fName) {
    FName = fName;
}
public String getLName() {
    return LName;
}
public void setLName(String lName) {
    LName = lName;
}
public String getBiography() {
    return Biography;
}
public void setBiography(String biography) {
    Biography = biography;
}
public Bitmap getImage() {
    return image;
}
public void setImage(Bitmap image) {
    this.image = image;
}

}