RTS_image(String name_of_roadsign) {
    this.Name_of_RoadSign = name_of_roadsign;
    imgURL = com.umusebo.RTS.ImagePreviewList.class.getResource(
        "images/01_Regulatory_Signs/01_Control_Signs/reg_cont_"
        + Name_of_RoadSign + ".jpg");
    img = Toolkit.getDefaultToolkit().createImage(imgURL);
}