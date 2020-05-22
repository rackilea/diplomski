// tell ui to not paint the background
button.setOpaque(false);
button.setContentAreaFilled(false);

// override paintComponent
protected void paintComponent(...) {
     // do custom backgroudn painting
     ...
     // let ui handle the foreground (it wont touch the background due to the false settings above)
     super.paintComponent()
}