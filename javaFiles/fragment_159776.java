Graphics g = combinedImage.getGraphics(); // Graphics object #1

combinedImage.createGraphics().setBackground(Color.white);  // Graphics object #2
// so now you've set the background color for the second Graphics object only

g.clearRect(0,0, 486, 151);  // but clear the rect in the first Graphics object
g.drawImage(partNumberImage, x, 18, null);
g.drawImage(lotNumberImage, x, 48, null);
g.drawImage(dteImage, x, 58, null);
g.drawImage(quantityImage, x, 68, null);