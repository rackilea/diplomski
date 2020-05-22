//bad code
ResultSet rs =  getDataFromDBMS("Select * from [tableName];");

Object temp = new objectToHoldInfoFromResultSet();

//loop over the result set
while (rs.next)//for each row in the result set
        {
        for(int i=1; i<=rs.getNumberColums; i++)
                {
                temp.add(infoAboutColumn);
                }
        temp.printInfo();//prints correct info
        anotherObject(makeUseOf(temp));//use info from first iteration.


        }

//Seemingly each loop into the while the temp.doSomethingToData(); uses the temp object created in the first iteration

//good code
ResultSet rs =  getDataFromDBMS("Select * from [tableName];");


//loop over the result set
while (rs.next)//for each row in the result set
        {
         Object temp = new objectToHoldInfoFromResultSet();//moving declaration of temp into the while loop solves the problem.
        for(int i=1; i<=rs.getNumberColums; i++)
                {
                temp.add(infoAboutColumn);
                }
        temp.printInfo();//prints current info

        anotherObject(makeUseOf(temp));//uses the current info.


        }