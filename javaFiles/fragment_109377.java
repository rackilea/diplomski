private String someReportUrl(HttpServletRequest request, HttpServletResponse response) {
    String url = "/standAlone/reportUrl.jsp";
    if (isBackToReportsSummary(request)) {
        url = SUMMARY_PAGE;
        getReportsSummary(request, response);
    } else if (isComingFromPageA(request)) {
        url = getTabUrl(request, REPORT_URL_FOR_PAGE_A);
    }
    return url;
}