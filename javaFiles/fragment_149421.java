public void play(View view) {
            onPlay(mStartPlaying);            
            if (mStartPlaying) {              
                setText("Stop playing");        
            } else {              
                setText("Start playing");     
            }          
            mStartPlaying = !mStartPlaying;      
}