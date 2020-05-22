FlowerPane flowerPane = new FlowerPane();
switch (JOptionPane.showConfirmDialog(null, flowerPane, "Flower", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)) {
    case JOptionPane.OK_OPTION:
        Flower flower = flowerPane.create();
        plantList.add(flower);
        break;
}