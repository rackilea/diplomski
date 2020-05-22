int zTmp=0;
                 do  
            {
                String country=myList.get(zTmp);
                if(inputCountry.equals(country))
                {

                    CalcDays(tmpTokens[iTmp]);
                    myDateList.clear();
                }zTmp++;
            }while(zTmp<myList.size());