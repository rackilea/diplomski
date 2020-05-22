import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PackageList {

    public static void main(String[] args) {

        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(1);
        }

        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(inputFile));
            for(int i=1; i < args.length;i++){  // For loop to  check - args[0] is file name so i = 1 
                boolean isDependencyExist = false; // check dependency
                while ((sCurrentLine = br.readLine()) != null) {
                    if(sCurrentLine.startsWith(args[i])){ // If file line starts with arg print
                        System.out.println(sCurrentLine);
                        isDependencyExist = true;
                        break;
                    }
                }
            if(!isDependencyExist){
                System.out.println(args[i] + " ->");
            }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}