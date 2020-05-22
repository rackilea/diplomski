branchInfoHtmlString = branchInfoString + 

      "<b>Branch Name: " + aBranch.getBranchName() + "</b>\n" +
      "<i>Branch No: " + aBranch.getBranchNo() + "</i>\n" + 
      "<font >Branch Phone No: " + aBranch.getBranchPhone() + "</font>\n" + 
      "<font color="#FFDDDDDD">Branch Timings: " + aBranch.getBranchTiming() + "</font>\n" + 

      "\n --------------------------------------- \n \n" ;  

// showing all the branch data in a text_view
setContentView(R.layout.db_branch_list) ;
TextView dbDataView = (TextView)findViewById(R.id.db_branch_list) ;
dbDataView.setText(Html.fromHtml(branchInfoHtmlString)) ;