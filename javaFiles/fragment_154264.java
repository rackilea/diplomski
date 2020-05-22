package jansi;

import java.io.IOException;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

public class Main {

    public static void main(String[] args) throws IOException {
        AnsiConsole.systemInstall();

        String[] sa = {"A", "B", "C"};
        Color[] ca = {Color.RED, Color.GREEN, Color.BLUE};
        for (int i = 0; i < sa.length; ++i ) {
            System.out.println(Ansi.ansi().eraseLine().fg(ca[i]).a(sa[i]).reset());
        }
    }
}