//assign a dummy json field as images and replace with poster

@SerializedName(value = "Images", alternate = {"Poster"}) //no whitespace
    private String Images;


@SerializedName("Poster ") //with white space
    private String Poster;