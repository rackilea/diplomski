import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

  private static ArrayList<City> loadDataFromFile() throws IOException {

    ArrayList<City> list = new ArrayList<City>();
    BufferedReader br = null;
    String sCurrentLine;
    br = new BufferedReader(new FileReader("C:\\temp\\cities.txt"));

    while ((sCurrentLine = br.readLine()) != null) {
      String[] splittedLine = sCurrentLine.split(",");
      City city = new City(splittedLine[0], Integer.parseInt(splittedLine[1]), splittedLine[2]);
      list.add(city);
    }

    br.close();
    return list;
  }

  public static void main(String[] args) throws IOException {

    ArrayList<City> list = loadDataFromFile();
    int input = Integer.parseInt(args[0]);
    Iterator<City> it = list.iterator();

    while (it.hasNext()) {
      City currentCity = it.next();
      if (currentCity.getPopulation() > input) {
        System.out.println("Cities with population greater than " + input + " : " + currentCity.getName() + "," + currentCity.getCountry());
      } else if (currentCity.getPopulation() == input) {
        System.out.println("City with population equals to " + input + " : " + currentCity.getName() + "," + currentCity.getCountry());
      } else {
        System.out.println("Cities with population lower than " + input + " : " + currentCity.getName() + "," + currentCity.getCountry());
      }
    }

  }
}