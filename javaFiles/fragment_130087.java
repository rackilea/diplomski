public class Kuular implements ActionListener {

    ImageIcon f1 = new ImageIcon("C:\\Users\\Student\\Desktop\\pic1.jpg");
    ImageIcon f2 = new ImageIcon("C:\\Users\\Student\\Desktop\\pic2.jpg");
    ImageIcon f3 = new ImageIcon("C:\\Users\\Student\\Desktop\\pic3.jpg");
    ImageIcon f4 = new ImageIcon("C:\\Users\\Student\\Desktop\\pic4.jpg");

    List<ImageIcon> list1 = Arrays.asList(f1, f2, f3, f4);
    List<ImageIcon> list2 = new ArrayList<ImageIcon>(); 

    public void fs() {
        Collections.shuffle(list1);
    }

    public static void main(String[] args) {
        Kuular k = new Kuular(); 
        k.fs();
    }
}