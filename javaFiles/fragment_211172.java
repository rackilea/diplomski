for (int k = 0; k < idArray.length ; k ++ )
          {
              query = "INSERT INTO Companies (ID,Company,Company2,Company3,Country,ZIP,City,Street," +
                    "Phone,Fax,Email,Internet,CustomerNo,AccountMngr,Icon,AddressSource," +
                    "UserDefined1,UserDefined2,CreatedOn,CreatedBy,ColectedInformation) " +
                    " VALUES ('" + UUID.randomUUID() + "','" + company_nameArray[k] 
                            + "','" + company_name2Array[k] + "','" + company_name3Array[k] + "','DE','"   
                            + zipArray[k] + "','" + cityArray[k] + "','" + streetArray[k] + "','"  
                            + phone_Array[k] + "','" + faxArray[k] + "','" + emailArray[k] + "','"
                            + internetArray[k] + "','" + customer_noArray[k] 
                            + "','d','131','60','Baufinder Import','Import Datum "
                            + dateFormat1.format(cal1.getTime()) + "','" 
                            + dateFormat1.format(cal1.getTime()) + "','d','" 
                            + "cxcxvcx" +  
                            "')";

              int updatedRowCount = Statement.executeUpdate(query);   
          }