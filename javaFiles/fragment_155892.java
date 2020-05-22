list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        // move it outside oncreate
        // no need to recreate this array everytime on click
        int[] points = new int[]{120,150,200,200,300,400,600};

        if(total_pts>=points[position]){
            total_pts-=points[position]; 
            totalPoints.setText("Total Points "+String.valueOf(total_pts));      
         }//else{ // optional 
            //totalPoints.setText("Not enough points");      
         //}
    }
});