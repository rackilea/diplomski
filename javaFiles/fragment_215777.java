if(inputDate!=null){
             try {
              DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
              date = formatter.parse(inputDate);
              java.sql.Date sqlDate = new java.sql.Date(date.getTime());
              oracle.jbo.domain.Date jboDate = new oracle.jbo.domain.Date(sqlDate);
                 System.out.println(jboDate);
               } catch (ParseException e) {
                       e.printStackTrace();
                }

         }