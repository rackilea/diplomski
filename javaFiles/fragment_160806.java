.setPositiveButton(R.string.alert_remove, new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int which){
        String[] res = null; // you initialised it with null
        for(int i=-1,l=usrCats.length; ++i<l;){ /*this line and the below line are condition 
    statemnts whose code may not run. so there are chances that your **res** will 
    remain initialised with null*/
            if(selections[i])
               res[i] = usrCats[i].toString();
        }
        if(res != null && res.length>0)// so here it shows a dead code warning.
           dbManager.removeUserShoppingCategories(res);
        }       
        })