int vert_spacing = (df.width - 2 * this.margin) / 20;
int extraSpace = df.width - (vert_spacing * 20);
int xOffset = extraSpace / 2;

// Draw the black border
g.setColor(Color.BLACK);
g.drawRect(this.margin + xOffset, this.margin, (df.width - extraSpace) - 2 * this.margin, df.height - 2 * this.margin);