public class ListExampleBetter {
    public static void main(String[] args) {
       final ListFrameBad listFrame=new ListFrameBad();
       listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //use SwingUtilities.invokeLater,it's ok
       SwingUtilities.invokeLater(new UpdateList(listFrame));
    }
}