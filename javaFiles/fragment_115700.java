for(currentnode=start; currentnode!=null; currentnode=currentnode.delnext){

        if(currentnode.deldata.startsWith(mykey)){

                        if(currentnode==start)
                            start=start.delnext;
                        else
                            prevnode.delnext=currentnode.delnext;

                        currentnode.deldata=null;

        }

        prevnode=currentnode;
    }

    }