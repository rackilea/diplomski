import com.helger.commons.csv.CSVReader;

CSVReader reader = new CSVReader(new FileReader("C:/Users/manoj/Downloads/View_All_names.csv"));
List row;
String name;
int counter = 1;

while ((row = reader.readNext()) != null) {
  name = row.get(1).toString();
  vars.put("name_" + counter, name);
  counter++;
}