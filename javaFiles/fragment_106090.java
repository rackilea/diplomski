int[] coords = new int[3];
int width = image.getWidth();
int height = image.getHeight();
for (coords[0] = 0; coords[0] < width; ++coords[0])
{
    for (coords[1] = 0; coords[1] < height; ++coords[1])
    {
        for (coords[2] = 0; coords[2] < depth; ++coords[2])
        {
            int x = coords[x_idx];
            int y = coords[y_idx];
            int z = coords[z_idx];
            …
        }
    }
}