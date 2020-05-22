// earlier on: myMap = new HashMap<GridButton, Integer>();
public void actionPerformed(ActionEvent gridButtonClicked) {
    GridButton gridButton = gridButtonClicked.getSource();
    int i = myMap.get(gridButton);
    gridButtonOwner[i] = turn + 1;
    gridButton.setBackground(playerColors[turn]);
    gridButton.setEnabled(false);
    System.out.println("Grid " + i + ": " + gridButtonOwner[i]);
}