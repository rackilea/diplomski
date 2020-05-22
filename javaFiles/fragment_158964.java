public void saveOfficer(Officers officer) {
        logger.info("In saveOfficer");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        try{

            logger.info("Values are "+officer.getUserName()+" "+StringSecurity.EncryptString(officer.getPassword())+" "+officer.getfName()+" "+officer.getoName()+" "+officer.getDivisionNo()+" "+officer.getPositionId()+" "+officer.getEmailAdd()+" "+dateFormat.format(officer.getStartDate())+" "+dateFormat.format(officer.getEndDate())+" "+ officer.getGenderId()+" "+officer.getPhoneNo()+" "+dateFormat.format(officer.getDob()));

            int count = getJdbcTemplate().update("INSERT INTO crimetrack.tblofficers (userName,password, fName, lName, oName, divisionNo, positionId, emailAdd, startDate, endDate, genderId,phoneNo, dob,badgeNo) "+
                                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                                                , new Object[]{officer.getUserName(),StringSecurity.EncryptString(officer.getPassword()),officer.getfName(),
                                                 officer.getlName(),officer.getoName(),officer.getDivisionNo(),officer.getPositionId(),
                                                 officer.getEmailAdd(),officer.getStartDate(),officer.getEndDate(),officer.getGenderId(),
                                                 officer.getPhoneNo(),officer.getDob(),officer.getBadgeNo()});

        logger.info(count +" Rows affected in tblOfficers");



        }catch(Exception e){

            logger.error("Could not save officer ", e);
        }       
    }