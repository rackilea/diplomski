Attendance attendance = document.toObject(Attendance.class);
Date startTime = attendance.getStartTime();
Date endTime = attendance.getEndTime();
if(timeToCheck.after(startTime) && (timeToCheck.before(endTime)) {
    //Do what you need to do
}