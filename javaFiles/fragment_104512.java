public Component pictureFactory() {
    if(javaVersion > "1.6") {
        return new PictureJava6();
    } else {
        return new Picture();
    }
}