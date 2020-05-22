private boolean isInSchoolYear(DateTime now, DateTime schoolYearStart, DateTime schoolYearEnd){
    int thisYear = now.getYear();
    schoolYearStart = schoolYearStart.withYear(thisYear);
    schoolYearEnd = schoolYearEnd.withYear(thisYear);

    if(schoolYearStart.isBefore(schoolYearEnd)){
        return new Interval(schoolYearStart, schoolYearEnd).contains(now);
    }
    else{
        return !(new Interval(schoolYearEnd, schoolYearStart).contains(now));
    }
}