public void state3(){
        search.clearFocus();
        listMain.removeFooterView(btnLoadMore); 
        tvError.setVisibility(View.INVISIBLE);
        tvMessage.setVisibility(View.INVISIBLE);
        finalfoodidint=Integer.parseInt(finalfoodid);
        if(finalfoodidint > oldlastid){

            listMain.addFooterView(btnLoadMore);

            System.out.println("1.5 + " + finalfoodidint);
            System.out.println("1.6 + " + oldlastid);

        }
        else if(finalfoodidint == oldlastid){
            //listMain.removeFooterView(btnLoadMore);
            listMain.removeFooterView(btnLoadMore);
            System.out.println("1.7 + " + finalfoodidint);
            System.out.println("1.8 + " + oldlastid);
        }
        else{
            listMain.removeFooterView(btnLoadMore);
            System.out.println("1.9 + " +finalfoodidint);
            System.out.println("1.10 + " +  oldlastid);

        }
        listMain.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(listMain);
        setListViewHeightBasedOnChildren(listCustom);
        setListViewHeightBasedOnChildren(listRecent);
    }