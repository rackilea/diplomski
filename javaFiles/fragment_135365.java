public List<CityStateRevenueReport> runReport() {

    List<CityStateRevenueReport> reports = 
                             new ArrayList<CityStateRevenueReport>();
    List<HashMap> maps = session.getNamedQuery("runReport").list()
    for ( HashMap map : results ) {
        CityStateRevenueReport report = new CityStateRevenueReport();
        report.setState(map.get("state"));
        report.setCity(map.get("city"));
        report.setRevenue(Double.parseDouble(map.get("revenue"));
        reports.add(report);
    }
    return reports;
}