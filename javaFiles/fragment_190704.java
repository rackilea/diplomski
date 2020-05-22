PID pid1 = adtMsg.getPID();
     String id = pid.getPatientIdentifierList(0).getID().getValue();
     System.out.println("PID : "+id);
     String last = pid1.getPatientName(0).getFamilyName().getSurname().getValue();
     String first = pid1.getPatientName(0).getGivenName().getValue();
     System.out.println("Patient Name : "+first+" "+last);