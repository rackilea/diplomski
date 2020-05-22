package net.snortum.play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecPlay {

    public static void main(String[] args) {
        new ExecPlay().start();
    }

    private void start() {
        String fileName = "not found";
        String ads = "not found";
        final String command = "cmd.exe /c dir /r"; // listing of current directory

        final Pattern pattern = Pattern.compile(
                  "\\s*"                 // any amount of whitespace
                + "[0123456789,]+\\s*"   // digits (with possible comma), whitespace
                + "([^:]+):"             // group 1 = file name, then colon
                + "([^:]+):"             // group 2 = ADS, then colon
                + ".+");                 // everything else

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;

                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        fileName = matcher.group(1);
                        ads = matcher.group(2);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(fileName + ", " + ads);

    }
}