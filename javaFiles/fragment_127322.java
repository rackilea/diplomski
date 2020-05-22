import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

class Test {
  public static void main(String[] args) throws IOException {
    ProcessBuilder pb = new ProcessBuilder("ffmpeg","-i","in.webm","out.mp4");
    final Process p = pb.start();

    new Thread() {
      public void run() {

        Scanner sc = new Scanner(p.getErrorStream());

        // Find duration
        Pattern durPattern = Pattern.compile("(?<=Duration: )[^,]*");
        String dur = sc.findWithinHorizon(durPattern, 0);
        if (dur == null)
          throw new RuntimeException("Could not parse duration.");
        String[] hms = dur.split(":");
        double totalSecs = Integer.parseInt(hms[0]) * 3600
                         + Integer.parseInt(hms[1]) *   60
                         + Double.parseDouble(hms[2]);
        System.out.println("Total duration: " + totalSecs + " seconds.");

        // Find time as long as possible.
        Pattern timePattern = Pattern.compile("(?<=time=)[\\d.]*");
        String match;
        while (null != (match = sc.findWithinHorizon(timePattern, 0))) {
          double progress = Double.parseDouble(match) / totalSecs;
          System.out.printf("Progress: %.2f%%%n", progress * 100);
        }
      }
    }.start();

  }
}