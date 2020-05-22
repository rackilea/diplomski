import java.io.File;
import java.util.ArrayList;
import java.util.List;

    public class Test{
          public static void main(String[] args) {
        List<String> account_files = new ArrayList<String>();
        System.out.println(System.getProperty("user.dir"));
        File[] files = new File(System.getProperty("user.dir")+"/account_info").listFiles();
        System.out.println(files.length);

                    for (File file : files) {
                        if (file.isFile()) {
                            account_files.add(file.getName());
                        }
                    }
                    for(int i = 0; i < account_files.size(); i++){
                        System.out.println(account_files.get(i));
                    }
          }
    }