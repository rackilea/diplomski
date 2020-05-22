for (Student s in populatedStudentList){
    if (s.getInitials().compareTo('a') != 0){
        continue;
    }
    String findId = s.getId();
    List<StudentDetail> tempListStudentDetail = new ArrayList<>(); 
    for (StudentDetail d in populatedStudentDetail){
        if (d.getId().compareTo(findId) == 0){
             tempListStudentDetail.append(d);
        }
    }
    s.setListStudentDetail(tempListStudentDetail);
}