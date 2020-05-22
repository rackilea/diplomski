import java.net.URL;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JApplet;
import javax.swing.JComponent;

public class JAppletGallery extends JApplet implements ActionListener {
    private JButton first;
    private JButton previous;
    private JButton next;
    private JButton last;
    private int cacheSize = 2;
    static int total = 400; // initial total total images
    int imageIndex = 0; // current image
    String msg = "";

    // gets folder's location
    String folderName = "/Users/Martynas/pictures/leicester/";
    File folder = new File(folderName);

    // initialise image object up to its total
    Image pictures[] = new Image[total];
    static String[] imageName = new String[total];

    public static void main(String[] args){
        final JAppletGallery ap = new JAppletGallery();
        if(args.length > 0){
            ap.folderName = args[0];

        }
        ap.folder = new File(ap.folderName);

        final JFrame f = new JFrame("Gal ");

        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
            //f.setDefaultCloseAction
                f.getContentPane().setLayout(null);
                f.getContentPane().add(ap);
                f.setBounds(0, 0, 700, 700);
                ap.setBounds(15, 15, 675, 675);//not a good way but fine for testing/ local
                //slp(1500)
                f.setVisible(true);

                ap.init();
                ap.start();
                f.invalidate();
                f.repaint();
            }
        });
    }

    // constructor
    public JAppletGallery() {

    }

    public void init() {
        makeGui();
        prepareImages();
    }

    private void makeGui() {
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        setSize(800, 600);

        // init buttons
        first = new JButton("First");
        first.setForeground(Color.BLACK);
        previous = new JButton("Previous");
        previous.setForeground(Color.BLACK);
        next = new JButton("Next");
        next.setForeground(Color.BLACK);
        last = new JButton("Last");
        last.setForeground(Color.BLACK);

        // init panel holder
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new java.awt.FlowLayout());
        btnPanel.add(first);
        btnPanel.add(previous);
        btnPanel.add(next);
        btnPanel.add(last);

        add(BorderLayout.NORTH, btnPanel);
        ImgShow imgs = new ImgShow();
        imgs.parent = this;
        add(BorderLayout.CENTER, imgs);

        first.addActionListener(this);
        previous.addActionListener(this);
        next.addActionListener(this);
        last.addActionListener(this);
    }

    public void drawNext() {

        imageIndex = imageIndex + 1;
        // checks for current image
        if (imageIndex == total) {
            imageIndex = 0;
        }
        picsLoadAndTrim();
        // sends index to display image
        repaint();
    }

    public void drawPrevious() {
        imageIndex = imageIndex - 1;

        if (imageIndex < 0) {
            imageIndex = total - 1;
        }
        picsLoadAndTrim();
        repaint();

    }

    private void picsLoadAndTrim() {

        int before = imageIndex - cacheSize;
        int before2 = total;
        if(before < 0){
            before2 = total + before;
        }
        int after = imageIndex + cacheSize;
        int after2 = -1;
        if(after >= total){
            after2 = after - total;
        }
        System.out.println("total " + total + " imageIndex " + imageIndex  + ", before " + before + ", after " + after + ", before2 " + before2+ ", after2 " + after2);
        for(int i =0; i < total ; i++){
            if((i >= before && i <= after) ||  (i <= after2) || (i >= before2)){
                System.out.println("CHECK " + i);
                if(pictures[i] ==null){//load only if not currently loaded

                    try {
                        pictures[i] = ImageIO.read(new File(folder, imageName[i]));
                    //loadImage(getDocumentBase()  , imageName[i]);
                    } catch (Exception e) {
                        msg = msg + " " + imageName[i];
                    }
                }else{
                }
            }else{
                System.out.println("rel " + i);
                pictures[i] = null; //release if loaded before
            }
        }
    }

    public URL getDocumentBase(){
        URL u = null;//super.getDocumentBase();
        try{
            if(u==null)u = new URL("file://" + folderName);
        }catch(Exception e){
            System.out.println(e);
        }
        return u;
    }
    public void drawFirst() {
        imageIndex = 0;
        picsLoadAndTrim();
        repaint();

    }

    public void drawLast() {
        imageIndex = total - 1;
        picsLoadAndTrim();
        repaint();
    }


    // Manage button actions
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == previous) {
            drawPrevious();
        } else if (e.getSource() == next) {
            drawNext();
        } else if (e.getSource() == first) {
            drawFirst();
        } else if (e.getSource() == last) {
            drawLast();
        }
    }

    // gets files from a folder - sub-method of displayImage()
    public  void filesFolder(File folder) {
        File[] listOfFiles = folder.listFiles();
        int index = 0;

        // puts image names in separate index of array
        for (File file : listOfFiles) {
            String s = file.getName().toLowerCase();
            if (file.isFile() && (s.endsWith(".png") || s.endsWith("jpg"))) {
                // System.out.println(file.getName());
                // assigning to String array for further manipulation
                imageName[index] = file.getName();
                index++;
            }
        }
        // total images count correction
        total = index;
        if(cacheSize > total)cacheSize = total;
    }

    private void prepareImages() {
        // gets image names from the folder
        filesFolder(folder);
        picsLoadAndTrim();
        //for (int p = 0; p < 1; p++) {

          //  pictures[p] = getImage(getDocumentBase(), folderName + imageName[p]);
        //}
    }



}

class ImgShow extends JComponent{
    JAppletGallery parent;


    public void paint(Graphics g) {
            if(parent.pictures[parent.imageIndex] != null){
                g.drawImage(parent.pictures[parent.imageIndex], 0, 35, this);
            }else{
                g.drawString(parent.msg, 10, 35);
                //err
            }
    }
}