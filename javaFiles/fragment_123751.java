public static void main(String Args[]){ 
    try {
        if(Args != null){
            if(Args[1] != null){//Load XML or prop File                 try{
                    properties.load(new FileInputStream(Args[1]));
                }catch(Exception e){
                    throw new Exception("Error loading PropertieFile: "+Args[1] + " :"+e.getMessage());
                }
            }else{
                throw new Exception("No File Found!");
            }