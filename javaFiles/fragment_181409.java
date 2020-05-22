public void downloadReportExcel(String path) {
    try {
        String url = "http://" + SSRS_IP + "/ReportServer?/" + path + "&rs:Format=Excel";

        FacesContext.getCurrentInstance().getExternalContext().redirect(url);

        return;
    } catch (IOException e) {
        throw new FacesException(e);
    }
}