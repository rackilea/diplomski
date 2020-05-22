import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import static java.awt.event.KeyEvent.*;

// ...

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        String multiLineText = jTextField1.getText()+"\n"+jTextField2.getText()+"\n"+jTextField3.getText()+"\n"+jTextField4.getText()+"\n"+jTextField5.getText();
        Scanner textReader = new Scanner(multiLineText);
        Robot r = new Robot();

        System.out.println("You have 5 seconds to focus the text box into which the text will be pasted!");

        for (int i = 0; i < 5; i++) {
            System.out.println(5 - i + "...");
            Thread.sleep(1000);
        }
        System.out.println("Start pasting...");
        while (textReader.hasNext()) {
            String line = textReader.nextLine().trim();
            System.out.println("\t> Pasting \"" + line + "\"");

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                            new StringSelection(line),
                            null);

            pressKeys(r, VK_CONTROL, VK_V);
            pressKeys(r, VK_TAB);
        }

    } catch (AWTException | InterruptedException ex) {
        throw new RuntimeException(ex);
    }
}

public static void pressKeys(Robot robot, int... keys) throws InterruptedException {
    for (int i = 0; i < keys.length; i++) {
        robot.keyPress(keys[i]);
        Thread.sleep(10);
    }
    for (int i = 0; i < keys.length; i++) {
        robot.keyRelease(keys[keys.length - i - 1]);
        Thread.sleep(10);
    }
    Thread.sleep(100);
}