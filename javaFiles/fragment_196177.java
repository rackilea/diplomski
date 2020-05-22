db().select(new Field[] { 
    TRANSITIONS.TRANSITION_ID, 
    TRANSITIONS.TYPE, 
    POSES.POSE_ID, 
    POSES.NAME, 
    IMAGES.URL, 
    IMAGES.SCORE.max() 
}).from(...)