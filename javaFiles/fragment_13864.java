import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CardFun extends JLayeredPane {
    private static final int PREF_W = 1200;
    private static final int PREF_H = 900;
    private static final Color BASE_COLOR = new Color(0, 80, 0);
    private static final int CARD_COUNT = 20;
    private static final int WIDTH_SHOWING = 20;
    private static final String PATH = "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/";
    private static final String BACK = "back.png";
    private Map<Card, Icon> cardIconMap = new HashMap<>();
    private Icon backIcon;
    private Deck deck = new Deck();
    private JPanel basePane = new JPanel(null);
    private JDialog optionDlg;

    public CardFun() throws IOException {
        LoadImageWorker worker = new LoadImageWorker();
        worker.addPropertyChangeListener(new LoadImageWorkerListener());
        worker.execute();
        basePane.setSize(getPreferredSize());
        basePane.setBackground(BASE_COLOR);
        add(basePane, JLayeredPane.DEFAULT_LAYER);

        final CardMouseAdapter mouseAdapter = new CardMouseAdapter(this, basePane);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        JProgressBar progBar = new JProgressBar();
        progBar.setIndeterminate(true);
        JOptionPane optionPane = new JOptionPane(progBar, JOptionPane.PLAIN_MESSAGE);
        optionDlg = optionPane.createDialog(null, "Waiting for Images to Load");
        optionDlg.setModalityType(ModalityType.APPLICATION_MODAL);

        optionDlg.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public Icon getBackIcon() {
        return backIcon;
    }

    public void setBackIcon(Icon backIcon) {
        this.backIcon = backIcon;
    }

    class LoadImageWorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                @SuppressWarnings("rawtypes")
                SwingWorker worker = (SwingWorker) evt.getSource();
                try {
                    if (optionDlg != null) {
                        optionDlg.setVisible(false);
                    }
                    worker.get();
                    for (int i = 0; i < CARD_COUNT; i++) {
                        Card card = deck.deal();
                        Icon cardIcon = cardIconMap.get(card);
                        JLabel cardLbl = new JLabel(cardIcon);
                        cardLbl.setSize(cardLbl.getPreferredSize());
                        int x = (PREF_W / 2) + WIDTH_SHOWING * (CARD_COUNT - 2 * i) / 2 - 
                              cardLbl.getPreferredSize().width / 2;
                        int y = PREF_H - cardLbl.getPreferredSize().height - WIDTH_SHOWING * 2;
                        cardLbl.setLocation(x, y);
                        basePane.add(cardLbl);
                     }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    System.exit(-1);
                };
            }
        }
    }

    class LoadImageWorker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            for (Card card : deck) {
                String imgPath = String.format("%s%s_of_%s.png", PATH, 
                        card.getRank().getText().toLowerCase(), 
                        card.getSuit().toString().toLowerCase());
                URL imgUrl = new URL(imgPath);
                // System.out.println(imgPath);
                BufferedImage img = ImageIO.read(imgUrl);
                int w = img.getWidth();
                int h = img.getHeight();
                BufferedImage img2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = img2.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(1, 1, w - 2, h - 2, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(1, 1, w - 2, h - 2, 10, 10);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                Icon icon = new ImageIcon(img2);
                cardIconMap.put(card, icon);
            }
            String backPath = PATH + BACK;
            URL imgUrl = new URL(backPath);
            // System.out.println(imgPath);
            BufferedImage img = ImageIO.read(imgUrl);
            setBackIcon(new ImageIcon(img));
            return null;
        }
    }

    private static void createAndShowGui() {
        CardFun mainPanel = null;
        try {
            mainPanel = new CardFun();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit( -1);
        }

        JFrame frame = new JFrame("CardFun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class CardMouseAdapter extends MouseAdapter {
    private JLabel selectedCard = null;
    private JLayeredPane cardGameTable = null;
    private JPanel basePane = null;
    private int deltaX = 0;
    private int deltaY = 0;

    public CardMouseAdapter(JLayeredPane gameTable, JPanel basePane) {
       this.cardGameTable = gameTable;
       this.basePane = basePane;
    }

    @Override
    public void mousePressed(MouseEvent mEvt) {
       Component comp = basePane.getComponentAt(mEvt.getPoint());
       if (comp != null && comp instanceof JLabel) {
          selectedCard = (JLabel) comp;
          basePane.remove(selectedCard);
          basePane.revalidate();
          basePane.repaint();

          cardGameTable.add(selectedCard, JLayeredPane.DRAG_LAYER);
          cardGameTable.revalidate();
          cardGameTable.repaint();
          deltaX = mEvt.getX() - selectedCard.getX();
          deltaY = mEvt.getY() - selectedCard.getY();
       }
    }

    @Override
    public void mouseReleased(MouseEvent mEvt) {
       if (selectedCard != null) {
          cardGameTable.remove(selectedCard);
          cardGameTable.revalidate();
          cardGameTable.repaint();

          basePane.add(selectedCard, 0);
          basePane.revalidate();
          basePane.repaint();
          selectedCard = null;
       }
    }

    @Override
    public void mouseDragged(MouseEvent mEvt) {
       if (selectedCard != null) {
          int x = mEvt.getX() - deltaX;
          int y = mEvt.getY() - deltaY;
          selectedCard.setLocation(x, y);
          cardGameTable.revalidate();
          cardGameTable.repaint();
       }
    }
 }

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

enum Rank {
    ACE("Ace"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE(
            "9"), TEN("10"), JACK("Jack"), QUEEN("Queen"), KING("King");

    private String text;

    private Rank(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}

class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit + ", rank=" + rank + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }
}

class Deck implements Iterable<Card> {
    private List<Card> cards;

    public Deck() {
        reset();
    }

    public final void reset() {
        cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(0);
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}