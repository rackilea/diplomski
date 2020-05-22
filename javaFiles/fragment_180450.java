private EventHandler<ActionEvent> createBtnFire(String name, ..
         List<ImageByteInfo> logos, boolean addressEntered, String... addressFields) {
    EventHandler<ActionEvent> createBtn = (ActionEvent e) -> {
        //code..
        entity.setCreationDate(creationDate);//null
        ImageByteInfo logo = logos.get(0);
        System.out.println(logo);
        entity.setImageByteInfoEntity(new ImageByteInfoEntity(logo.getByteImage(), logo.getWidth(), logo.getHeight()));
        //code..
        startUI.continueToMainContent();
    };
    return createBtn;
}