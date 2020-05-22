Bundle bundle= getIntent().getExtras();
    if (bundle!= null) {// to avoid the NullPointerException
        isUpdate=bundle.getBoolean("update");
        if(isUpdate)
        {
           id=bundle.getString("TransId");
           transname=bundle.getString("TransName");
           transamount=bundle.getString("TransAmount");
           transtype=bundle.getString("TransType");
           transdate=bundle.getString("CategDate");
           transcategid=bundle.getString("CategCategId");
           txtCashflow.setText(transname);
           txtType.setText(transtype);
           txtAmount.setText(transamount);
       }
    }