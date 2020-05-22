public class ReportGenerator {

private static HashMap<String, List<ReportGenreratorFields>> reportGeneratorMapper = new HashMap<>();

public static void main(String[] args) throws Exception {
    try (ElasticSearchClient client = new ElasticSearchClient()) {
        SearchResponse sr = client.dailyReport();
        SearchHit[] results = sr.getHits().getHits();

        for (SearchHit hit : results) {
            ReportGenreratorFields reportGenreratorFields = new ReportGenreratorFields();
            reportGenreratorFields.setTestname(source.get("test_name").toString());
            reportGenreratorFields.setJenkinsBuildNumber(source.get("job_build_number").toString());
            if (source.get("link_issue") != null) {
                reportGenreratorFields.setJiraLinkedIssue(source.get("link_issue").toString());
            } else {
                reportGenreratorFields.setJiraLinkedIssue("new_bug");
            }
            String indeniVer = source.get("indeni_version").toString();
            //map contains that indeniVer then add to existing list
            if (reportGeneratorMapper.containsKey(indeniVer)) {
                List<ReportGenreratorFields> reportGeneratorFieldsList = reportGeneratorMapper.get(indeniVer);
                reportGeneratorFieldsList.add(reportGenreratorFields);
                reportGeneratorMapper.put(indeniVer, reportGeneratorFieldsList);
            } else { //map does not contain that indeniVer
                List<ReportGenreratorFields> reportGeneratorFieldsList = new ArrayList<>();
                reportGeneratorFieldsList.add(reportGenreratorFields);
                reportGeneratorMapper.put(indeniVer, reportGeneratorFieldsList);
            }
        }
    } catch (IOException e) {
        LOG.error("failed to fetch documents from elastic search cluster", e);
    }
  }
}