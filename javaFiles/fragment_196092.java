if (e.getSource() == addImage) {
    JLabel lorryImage = new JLabel(lorryPicture);
    imageSpaces[imageCounter].add(lorryImage);
    imageSpaces[imageCounter].revalidate();
    imageSpaces[imageCounter].repaint();
    imageCounter++;
}