sql =" insert into data"
                    +"(Type_ID,price,buy_Link,Site_Comment)"
                    +"values" 
                    + "('" + 1   + "','"


                    +ele.select("td.PTPrice").text().replace(" ر.س","")   +"','"
                    +ele.select("td.PTmodel a").attr("abs:HREF")  +"','"
                    +ele.select("td.PTmodel").text()+
                     "');";