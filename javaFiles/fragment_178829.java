public class MailBox {
  public static void main(String[] args) {
    boolean[] amountToflip = new boolean[100];

    // Perform the flipping
    for (int increment=1; increment <= amountToflip.length; increment++) {      
        for (int boxnum=increment - 1; boxnum < amountToflip.length; boxnum+=increment) {
            amountToflip[boxnum] = !amountToflip[boxnum];
        }
    }

    // Now print the result
    for (int i = 0; i < amountToflip.length; i++) {
        if (amountToflip[i]) {
            System.out.println("Mailbox: " + i);
        }
    }
  }
}