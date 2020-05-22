if (job.showPrintDialog(null)) {
    JobSettings js = job.getJobSettings();
    for (PageRange pr : js.getPageRanges()) {
        for (int p = pr.getStartPage(); p <= pr.getEndPage(); p++) {
            boolean ok = job.printPage(...code to get your node for the page...);
            ...take action on success/failure etc.
        }
    }
}