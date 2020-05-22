import 'dart:html';
import 'dart:convert';

void loadData()
{
  var url = "http://localhost:8080/***selectAll";

  //call the web server asynchronously
  var request = HttpRequest.getString(url).then(onDataLoaded);

}



void onDataLoaded(String response)
{
  TableElement table = querySelector("#domainTableSelector");
  //table.children.add();

  var jsonString = response;
 // print(jsonString);

  var jsonObject = JSON.decode(jsonString);

  for (var x = 0; x < jsonObject.length; x++) 
  {
    //create new table row 
    TableRowElement row = table.insertRow(x+1);

      for (var d in jsonObject[x]["serviceResponseValue"]) {
        TableCellElement cell = row.insertCell(x);
        cell.text = d["assetId"];

        cell = row.insertCell(x);
        cell.text = d["domainName"];

        cell = row.insertCell(x);
        cell.text = d["ipAddress"];

        print(d["assetId"]);
        print(d["domainName"]);
        print(d["ipAddress"]);

      }
     // print(list);
  }

}