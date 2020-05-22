int tileWidth = 30;
int tileHeight = 30;
// Coordinates in the physical world, like a mouse point for example...
int x = ...;
int y = ...;

int col = (int)Math.floor(x / (double)tileWidth);
int row = (int)Math.floor(y / (double)tileHeight);