import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UtilsMethod {

    private XSSFWorkbook workbook = new XSSFWorkbook();

    /*
     * Take a Map of integer and List of string and
     *Create a Xlsx file on given path with number of row equal to size of nameList And number of Cell equal to keyset size
     */
    public void initializeExcelFile(Map<Integer,List<String>>hashmap,String path) throws IOException{

        FileOutputStream out = new FileOutputStream( new File(path));
        Set<Integer> keyset = hashmap.keySet();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = null;
        List<String> nameList = hashmap.get(keyset.toArray()[0]);

        for(int j=1; j<nameList.size()+1;j++){
            row = sheet.createRow(j);
            if(null != row){
                for(int i=0;i<keyset.size();i++){
                    row.createCell(i);
                }
            }
        }

        workbook.write(out);
        out.close();
    }

    /*
     * Use initializeExcelFile(hashmap,path) to initialize a Xlsx file in given path 
     * After that, write the  content of hashmap into Xlsx file
     */
    public void writeToExcelfile(Map<Integer,List<String>>hashmap,String path) throws IOException{

        Set<Integer> keyset = hashmap.keySet();
        InputStream inp = new FileInputStream( new File(path));
        FileOutputStream out = new FileOutputStream( new File(path));
        int rownum = 1;
        int cellnum = 0;

        initializeExcelFile(hashmap,path);

        workbook = new XSSFWorkbook(inp);

        XSSFSheet sheet = workbook.getSheetAt(0);

        for(Integer key : keyset){
            List<String> nameList = hashmap.get(key);
            for(String s : nameList){
                XSSFRow row = sheet.getRow(rownum++);
                Cell cell = row.getCell(cellnum);
                if(null!=cell){
                    cell.setCellValue(s);
                }
            }
            cellnum++;
            rownum=1;
        }

        workbook.write(out);
        out.close();
        inp.close();
    }

    public Map<Integer,List<String>> putListIntoMap(List<ExportReport>exportReports) {

        Map<Integer,List<String>> exportRep = new TreeMap<Integer, List<String>>();
        List<String> descriptions = new ArrayList<String>();
        List<String> exportIntervalIds = new ArrayList<String>();

        for(ExportReport report:exportReports){
            descriptions.add(report.getDescription());
            exportIntervalIds.add(report.getExportIntervalId().toString());
        }

        exportRep.put(1, descriptions);
        exportRep.put(2, exportIntervalIds);

        return exportRep;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}