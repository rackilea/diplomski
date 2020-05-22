// Get buttons
Button button1 = (Button)findViewById(R.id.bcontra);
Button button2 = (Button)findViewById(R.id.bafavor);
Button button3 = (Button)findViewById(R.id.bnaosei);

// Enable or disable buttons
button1.setEnabled(false);
button2.setEnabled(true);
button3.setEnabled(true);

// subtract a vote (if needed)
switch(whereVote){
    case FAVOR_VOTE: afavor--; break;
    //case CONTRA_VOTE: contra--; break;
    case NAOSEI_VOTE: naosei--; break;
    default: break;
}
whereVote=CONTRA_VOTE;   

// increase vote
contra = contra + 1;
display1(contra);