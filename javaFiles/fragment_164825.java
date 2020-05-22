int width = data.length;
int height = data[0].length;

int[] flattenedData = new int[width*height*3];
BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
int ind = 0;
for (int i = 0; i < width; i++)
{
    for (int j = 0; j < height; j++)
    {
        greyShade = data[i][j];
        flattenedData[ind + j*3] = greyShade;
        flattenedData[ind + j*3+1] = greyShade;
        flattenedData[ind + j*3+2] = greyShade;

      }
    ind += height*3;
}       

img.getRaster().setPixels(0, 0, 100, 100, flattenedData);

JLabel jLabel = new JLabel(new ImageIcon(img));

JPanel jPanel = new JPanel();
jPanel.add(jLabel);
JFrame r = new JFrame();
r.add(jPanel);
r.show();