import java.io.BufferedWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

class DocxToCSV {

 public static void main(String[] args) throws Exception {

  Locale.setDefault(Locale.FRENCH);

  List<String[]> data = new ArrayList<String[]>();
  data.add(new String[]{"F1", "F2", "F3", "F4"});
  data.add(new String[]{"Être un membre clé", "Être clé", "membre clé"});
  data.add(new String[]{"Être", "un", "membre", "clé"});

  Path path = Paths.get("test.csv");
  BufferedWriter bw = Files.newBufferedWriter(path);

  //bw.write(0xFEFF); bw.flush(); // write a BOM to the file

  CSVWriter writer = new CSVWriter(bw, ';', '"', '"', "\r\n");
  writer.writeAll(data);
  writer.flush();
  writer.close();

 }
}