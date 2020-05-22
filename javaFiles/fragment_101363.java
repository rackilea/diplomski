import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class readFile {

    public static class Brick{
        public Brick(int a,int b){System.out.println("constructor for 2 params: "+a+", "+b);}
        public Brick(int a,int b,int c,int d){System.out.println("constructor for 4 params: "+a+", "+b+", "+c+", "+d);}
    }

    public static void main(String[] args) throws Exception {
        String line;

        InputStream fis = new FileInputStream("map.txt");
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            StringTokenizer tokens = new StringTokenizer(line.trim());
            while(tokens.hasMoreTokens()){
                String type = tokens.nextToken();
                if(type.equals("Brick")){
                    int params = tokens.countTokens();
                    switch(params){
                        case 2: new Brick(Integer.parseInt(tokens.nextToken()),
                                          Integer.parseInt(tokens.nextToken()));
                            break;
                        case 4: new Brick(Integer.parseInt(tokens.nextToken()),
                                          Integer.parseInt(tokens.nextToken()),
                                          Integer.parseInt(tokens.nextToken()),
                                          Integer.parseInt(tokens.nextToken()));
                            break;
                        default: throw new Exception("Wrong line:"+line);
                    };
                }
            }
        }
    }
}