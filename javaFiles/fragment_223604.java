//Creating a file of name 'filename'
        dir_1=new File(path+"/<filename you want to save>.csv");
        parent=dir_1.getParentFile();
        if(!parent.exists())
          parent.mkdirs();
        pw = new PrintWriter(dir_1);
        sy=driver.getPageSource();//Getting the HTML source code
        HTMLpageContent = Jsoup.parse(sy);
        table = HTMLpageContent.getElementById("cross_rate_markets_stocks_1");
        header = table.getElementsByTag("th");
        bodyrows = table.getElementsByTag("tr");
        for(Element headerData:header)
          data+=headerData.text()+",";//Storing column names in string data
        data=data.substring(0,(data.length()-1));
        data+="\n";
        for(Element row:bodyrows)
        {
          rowContent=row.getElementsByTag("td");
          for(Element rowData:rowContent)
          {//Extracting data of a row and storing
            val=rowData.text();//Some data may contain , in there data
            if(checkComma(val))
            {
              val=val.substring(0,val.indexOf(','))+val.substring(val.indexOf(',')+1);
            }
            data+=val+",";
          }
          data=data.substring(0,(data.length()-1));
          data+="\n";
        }
        pw.write(data);
        pw.close();
        System.out.println("Successfull in generating "+name+".csv");