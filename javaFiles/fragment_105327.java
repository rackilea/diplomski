for(int i=0;i<getCdSettore().length;i++){
        int flag=0;
        for(int j=0;j<getSelected().length;j++){
            if(getCdSettore()[i].equalsIgnoreCase(getSelected()[j]))
            {
                flag++;
            }
        }
        if(flag==0)
        {
         System.out.println("not selected :"+getCdSettore()[i]);
        }
    }