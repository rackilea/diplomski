package application;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.nio.charset.StandardCharsets;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.text.ParseException;

    public class T {
        public static void main(String[] args) throws ParseException {
            String filename="location.txt";
            Path pathToFile = Paths.get(filename);
            FileWriter fstream = null;
            BufferedWriter bw=null;
            PrintWriter pw=null;
            try {
                fstream = new FileWriter(filename, true);
                bw=new BufferedWriter(fstream);
                pw=new PrintWriter(bw);
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
                String line = br.readLine(); 
                while (line!=null) { 
                    String[] attributes = line.split(" "); 
                    System.out.print("Sensor["+attributes[0]+"] : ");
                    double x=Double.parseDouble(attributes[1]);
                    double y=Double.parseDouble(attributes[2]);
                    GeoHash geoCode=GeoHash.withCharacterPrecision(x, y, 10);
                    System.out.print(geoCode+"\n");
                    pw.println(line+" "+geoCode);
                    sb.append(line+" "+geoCode);
                    line = br.readLine(); 
                } 
                PrintWriter writer = new PrintWriter(filename);
                writer.print("");
                writer.close();
                br.close();
                pw.close();
                bw.close();
                fstream.close();
            } catch (IOException ioe) { 
                    ioe.printStackTrace(); 
            }
            System.out.println("Generated!!");
        } 

    }