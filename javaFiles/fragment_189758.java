public CustomReport createCustomReport(CustomReport customReport) {
   customReport.getCustomReportActivitySet.forEach((activity) -> {
      activity.setCustomReport(customReport);
   });

   return customReportRepository.save(customReport);
}