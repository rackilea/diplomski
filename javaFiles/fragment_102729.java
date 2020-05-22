import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat;
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef;

class MyJasperController {
    def jasperService

    def showReport = {
        def reportDef = new JasperReportDef(
            name: 'your_report.jasper', 
            parameters: params,
            fileFormat: JasperExportFormat.HTML_FORMAT)

        def report = jasperService.generateReport(reportDef)
            .toByteArray().toString("UTF-8")

        render report
    }
}