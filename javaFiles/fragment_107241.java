public float returnSomething(String theThing) {
    switch (theThing) {
        case "height":
            return height;
        case "rotation" :
            return  rotation;
        case "width":
            return  width;

        default:
            return 0;
    }
}