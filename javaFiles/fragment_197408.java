import com.example.Course;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

public class XlsxStreamingView extends AbstractXlsxStreamingView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xlsxStreaming-file.xlsx\"");

        @SuppressWarnings("unchecked")
        List<Course> courses = (List<Course>) model.get("courses");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Spring MVC AbstractXlsxStreamingView");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Date");

        // Create data cells
        int rowCount = 1;
        for (Course course : courses){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(course.getId());
            courseRow.createCell(1).setCellValue(course.getName());
            courseRow.createCell(2).setCellValue(DATE_FORMAT.format(course.getDate()));
        }
    }
}