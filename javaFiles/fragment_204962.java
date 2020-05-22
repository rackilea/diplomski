String desc = null;
        try{
        desc = attributes.getValue("description");
        if((desc == null) || (desc.length()<=0)){
            desc = null;    
        }
        }catch(Exception ex){
            desc = null;
        }
if(parseList != null){
parseList.setFolderdesc(desc);  
}