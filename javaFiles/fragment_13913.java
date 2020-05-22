public class SO{
  public static void main(String[] args) {
    int choice = 0;
    do{
        choice = JOptionPane.showConfirmDialog(null, "Continue?");
    } while(choice == JOptionPane.YES_OPTION);
  }
}