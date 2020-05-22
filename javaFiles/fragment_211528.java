Date fileStartDate = fileFacade1.get_startdate(fileID, hash);
Date fileEndDate = fileFacade1.get_enddate(fileID, hash);

Date currentDate = new Date();

if (fileStartDate.before(currentDate) && fileEndDate.after(currentDate) {
  ...