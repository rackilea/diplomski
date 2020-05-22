public void leftTrue(){ 
    left = true;
    //if the function is rightTrue() then set right = true;
    if(left && right){
        String testID = self.getId();
        for(int i = 0; i < connectList.size(); i++){
            String testID2 = connectList.get(i).getL();
            if(testID == testID2){
                left = true;
                right = true;
                connectList.get(i).setT(left);
                connectList.get(i).setI(right);
            }
        }
    }else{
        connectList.add(new NodeList<Boolean, Boolean, String>(left, right, linkedNodeID));
    }
}