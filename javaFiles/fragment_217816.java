String sql= "update Staff_information set id='"
             +value4+"',first_name='"
             +value1+"', surname='"
             +value2+"', " + "Dob='"
             +value3+"',Email='"
             +value5+"',Telephone='"
             +value6+"'," + "Address='"
             +value7+"',Department='"
             +value8+"', Address2 = '"
             +value9+"', " + "Apartment = '"
             +value10+"', Post_code ='"
             +value11+"', " + "Designation ='"
             +value12+"', Status ='"
             +value13+"', Salary ='"
             +value14+"', job_title ='"
             +value15+"', Date_Hired ='"
             +value16+"',Gender='"+gender+"', Image=? where id='"+value4+"' ";
     pst=conn.prepareStatement(sql);
pst.setBytes(1, somevaluehere);** 

     pst.execute();