public void setIcons(List<JFrame> frames, Image icon) {
    List<Image> iconAsList = new ArrayList<Image>();
    iconAsList.add(icon);
    for(JFrame frame: frames) {
        frame.setIconImages(iconAsList);
    }
}