import java.util.Arrays;

public class Kata {
public static int findShort(String s) {

int shortestLocation = 0;
String[] words = s.split("");
int shortestLength=(words[0]).length();
    for(int i=0;i<words.length;i++){
      if ((words[i]).length() < shortestLength) {
        shortestLength=(words[i]).length();
        shortestLocation=shortestLength;
      }

    }

 return shortestLocation;
        }
  }