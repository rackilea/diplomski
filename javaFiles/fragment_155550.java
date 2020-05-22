for (Object patObj : patList) {

      PatientCSV pat = (PatientCSV) patObj;
      if(((PatientCSV) patObj).getPatID().equals(sID)){

          return pat.getPseudoID();
      }
      else
      {  

          PatientCSV pat1 = new PatientCSV();
          pat1.setPatID(sID);
          pat1.setPseudoID(pseudoID);
          patList.add(pat1);
          /*Find a way to import it to the CSV*/
          bc.write(pat1);
          writer.close();
          return pseudoID;
      }
  }