function sendMail(){
  var ss = SpreadsheetApp.getActiveSpreadsheet();   //Get the active Spreadsheet
  var sheet = ss.getSheetByName('Sheet1');     //Get the sheet by name, Sheet1 as example
  var startRow = 2;     //We start process things from row 2
  var lastRow = sheet.getLastRow();    //Get the last row of data to be processed
  var lastCol = sheet.getLastColumn();  // Get the last column of data to be processed
  var range = sheet.getRange(2,1,lastRow,lastCol);  //Fetch the range
  var data = range.getValues();   //Get the values inside the range
      for (var i = 0;i<data.length;i++)   //Iterate values
        var row = data[i];   //Set up variable for easier retrieve data to be processed and more understandable by human
        var FirstName = row[1];  //Column B
        var LastName = row[2];   //Column C
        var emailAddress = row[3];  //Column D
        var dueDate = Utilities.formatDate(new Date(row[4]),'GMT+0800','MM/dd/yyyy');   //Column E. Utilities format so the date won't be in long values
        var timer = row[6];  //Column G
        var msg = 'Hello '+FirstName+' '+LastName+'<br><br>'   // Your templates
                 +'This is a test mail '+dueDate+'<br><br>'
                 +'Bla bla bla<br>'
                 +'Another lines of texts<br><br>'
                 +'Another lines of texts<br><br>'
                 +'Thank You<br><br>'
                 +'OH!! I like Banana.';
            if(timer == 3){   //Set up the condition
            GmailApp.sendEmail(emailAddress,'Your Renty Rental is Due Soon!',msg,{htmlBody:msg});   //Send the email to the recipient
            sheet.getRange(startRow+i,7).setNote('Email Sent');  //Set note on column 'G' 
            }
}