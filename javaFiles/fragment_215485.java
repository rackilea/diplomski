package com.example.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> commands = new ArrayList<String>();
            commands.add("/bin/sh");
            commands.add("-c");
            commands.add("grep -rni --include \"*.java\" \"public static void main(\" /home/user/dev/java/Parser/parser");

            Process process = new ProcessBuilder(commands).start();
            Analyzer analyzer_is = new Analyzer(process.getInputStream());
            Analyzer analyzer_es = new Analyzer(process.getErrorStream());

            analyzer_is.start();
            analyzer_es.start();

            process.waitFor();

            analyzer_is.join();
            analyzer_es.join();

            System.out.println("Exit Code: " + process.exitValue());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


package com.example.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Analyzer extends Thread {

    InputStream is = null;

    public Analyzer(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.is));

            String line = "";
            while((line = br.readLine()) != null) {
                  System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}