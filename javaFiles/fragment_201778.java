static ArrayList<ClaimTableProperties> claimstable = new ArrayList<ClaimTableProperties>();

    JCoTable claims = function.getTableParameterList().getTable("CLAIM_DETAILS");

    claims.firstRow();
    int rownums = claims.getNumRows();
    ClaimTableProperties[] ctp = new ClaimTableProperties[rownums];

    for (int i = 0; i < rownums; i++) {
            ctp[i] = new ClaimTableProperties();
            ctp[i].setBelnr(claims.getString("BELNR"));
            ctp[i].setBktxt(claims.getString("BKTXT"));
            ctp[i].setZuonr(claims.getString("ZUONR"));
            ctp[i].setBlart(claims.getString("BLART")); 
            claimstable.add(ctp[i]);
            claims.nextRow(); 
    } // End for