import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Test {


    public static void main(String[] args) throws IOException {

        ExportReport exportReport = new ExportReport();
        exportReport.setExportIntervalId(11);
        exportReport.setDescription("ACCSDESCRIPTION1");

        ExportReport exportReport2 = new ExportReport();
        exportReport2.setExportIntervalId(1);
        exportReport2.setDescription("ACCSDESCRIPTION2");

        ExportReport exportReport3 = new ExportReport();
        exportReport3.setExportIntervalId(4);
        exportReport3.setDescription("ACCSDESCRIPTION3");

        ExportReport exportReport4 = new ExportReport();
        exportReport4.setExportIntervalId(12);
        exportReport4.setDescription("ACCSDESCRIPTION4");

        List<ExportReport> exportReports = new ArrayList<ExportReport>();

        exportReports.add(exportReport);
        exportReports.add(exportReport2);
        exportReports.add(exportReport3);
        exportReports.add(exportReport4);

        UtilsMethod utilsMethod = new UtilsMethod();

        Map<Integer,List<String>> map = utilsMethod.putListIntoMap(exportReports);
        System.out.println(map);


        utilsMethod.writeToExcelfile(map, "Writesheet.xlsx");

        System.out.println("Writesheet.xlsx written successfully" );

    }

}