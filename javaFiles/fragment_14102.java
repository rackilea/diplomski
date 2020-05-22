import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@RequiredArgsConstructor
public class MyRest {

    @Autowired
    private ProductRepository repo;

    private final int PAGESIZE = 1000;

    @RequestMapping("/")
    public String loadData() {
        for (int record = 0; record < 10_000; record += 1) {
            repo.save(new Product(record, "Product " + record));
        }
        return "Loaded Data";
    }

    @RequestMapping("/csv")
    public void downloadData(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String[] header = {"id", "name"};
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        long numberRecords = repo.count();
        for (int fromRecord = 0; fromRecord < numberRecords; fromRecord += PAGESIZE) {
            Pageable sortedByName = PageRequest.of(fromRecord, PAGESIZE, Sort.by("name"));
            Page<Product> pageData = repo.findAll(sortedByName);
            writeToCsv(header, csvWriter, pageData.getContent());
        }
        csvWriter.close();
        response.getWriter().flush();
        response.getWriter().close();
    }

    private void writeToCsv(String[] header, ICsvBeanWriter csvWriter, List<Product> pageData) throws IOException {
        for (Object line : pageData) {
            csvWriter.write(line, header);
        }
    }

}