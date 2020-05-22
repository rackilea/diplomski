for(String thissubhead: ConstructedList){
     SubHead subHead = SubHead.retrievebyName(thissubhead);
     SubHeadDepartment subHeadDepartment = new SubHeadDepartment();
     subHeadDepartment.department = department;
     subHeadDepartment.subhead = subHead;
     subHeadDepartment.save();
    }