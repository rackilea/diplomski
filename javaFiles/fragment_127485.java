@Controller
public class CustomController {
    @Autowired
    ReportService reportService; //this inject's your bean here.

    List<Report> getReports() {
        return reportService.findAllReports();
    }
}