Graphics2D g = combinedImage.createGraphics(); 
g.setBackground(Color.white);

//  Now there is only one Graphics object, and its background has been set
g.clearRect(0,0, 486, 151);  // This now uses the correct background color
g.drawImage(partNumberImage, x, 18, null);
g.drawImage(lotNumberImage, x, 48, null);
g.drawImage(dteImage, x, 58, null);
g.drawImage(quantityImage, x, 68, null);