import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gpio_prg {
    public void out() throws IOException, InterruptedException{
        String command = "python /home/pi/noirLedControl.py";
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        System.out.print("led status = ");
        System.out.println(reader.readLine());
        proc.waitFor();
        }
}