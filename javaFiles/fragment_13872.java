public class CardImage {

    BufferedImage img = null;

    public CardImage(Card card) {
        setImage(card);
    }

    public BufferedImage getImage() {
        return img;
    }

    public BufferedImage setImage(Card c) {
        try {
            //img = ImageIO.read(new File("/media/billy/HOME/workspace/Shithead/src/cards/" + toName(c)));
            img = ImageIO.read(getClass().getResource("/cards/" + toName(c)));
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
int scale_factor = 8;
System.out.println(img.getHeight());
Image dimg = img.getScaledInstance((int)img.getWidth()/scale_factor, (int)img.getHeight()/scale_factor, Image.SCALE_SMOOTH);


Graphics g = img.createGraphics();
g.drawImage(dimg, 0, 0, null);
g.dispose();
         */
        return img;
    }

    public String toName(Card c) {
        String tmp = c.toString().replaceAll(" ", "_");
        tmp = tmp.toLowerCase();
        tmp = tmp + ".png";
        return tmp;
    }

}