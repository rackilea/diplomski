qry="select new com.yourpackage.DoctorShift(s.shiftNameId,s.shiftName,d.doctorRegnumvar,"
      +"d.doctorFnamevar,d.doctorLnamevar,d.doctorstatus," 
      +"sm.shiftstatus,s.shiftTime) from ShiftDaoBean s,"
      + "DoctorDaoBean d,DoctorShiftMappingBean sm where "
      +"d.doctorid=sm.doctoridfk and  s.shiftID=sm.shiftidfk"
      +" and d.doctorid=:doctorID ";