Image[] card = new Image[52];
String fileLocation = new String();
for (int i = 0; i < 52; i++)
    {
        fileLocation = "C:\\Users\\con25m\\Pictures\\" + i + ".jpg";
        card[i] = new Image(fileLocation);
    }