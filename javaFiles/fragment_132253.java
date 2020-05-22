//fill it with the shapes base sizes (index 0 = width, index 1 = height)
Map<Shape,int[]> shapeSizes = new HashMap<Shape,int[]>();
public void paintComponent(Graphics g) {
double widthCoeff = this.getWidth()/(double)Window.this.defaultWidth;
double heightCoeff = this.getHeight()/(double)Window.this.defaultHeight;
for (int i = 0; i< paintList.size(); i++) {
Shape s = paintList.get(i);
int[] baseSize = shapeSizes.get(s);
int oldWidth = baseSize[0], oldHeight = baseSize[1];
int width = oldWidth*widthCoeff, height = oldHeight*heightCoeff;
//you can now give the shape its new width and height
}
}