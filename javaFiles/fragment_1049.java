//get the view object your calendar uses
CalendarVOImpl voImpl = getCalendarVO();
ViewCriteria vc = voImpl.createViewCriteria();
//Just some name for the view criteria
vc.setName("filterCalendar");
ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
//Set the name of the attribute and the value you're looking to filter by
vcRow.setAttribute("NameOfAttribute", "IN (" + valueFilter + ")");
vc.insertRow(vcRow);
voImpl.applyViewCriteria(vc);
voImpl.executeQuery();