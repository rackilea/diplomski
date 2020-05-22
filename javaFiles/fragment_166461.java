public class Report {
    private String header;
    private String data;
    ...
    private String footnote;
    ...
}

Report carReport = Report ("Car", "Data about the car ...", ...); 
// send carReport to be presented.
...
Report dogReport = Report ("Dog", "Data about the dog...", ...);