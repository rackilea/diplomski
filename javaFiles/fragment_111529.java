ps1 = con.prepareStatement(
                 "select stuId, name, relationsName, houseAddress, houseNumber from temp where "
                    + " stuId like ? and " 
                    + " sex = ? and " 
                    + " name like ? and "
                    + " age BETWEEN ? and ? and "
                    + " relationsName like ? " 
                    + " order by name asc limit 0, 150000 "
           );