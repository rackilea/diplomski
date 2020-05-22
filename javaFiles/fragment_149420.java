OnClickListener clicker = new OnClickListener() {  
    public void onClick(View v) {          
        onPlay(mStartPlaying);            
        if (mStartPlaying) {              
            setText("Stop playing");        
        } else {              
            setText("Start playing");     
        }          
        mStartPlaying = !mStartPlaying;      
    }      
};      
Button b = findViewById(R.id.play_button);
b.setOnClickListener(clicker);