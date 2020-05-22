//SEE INLINE COMMENTS
// images 
//No definition provided. May be putting values into the imgs map.
loadImages();
//this.DEFAULT_IMAGE_ID is some imageID. imgs.get gets the value for that imageID, which
//is ImageIcon for that imageID. That is stored in actualImage variable.
actualImage = imgs.get(this.DEFAULT_IMAGE_ID);
//Creating a new JLabel with actualImage.
JLabel label = new JLabel(actualImage);