@Override
public void finish() {
    if( bLetsFinish ){
        super.finish(); //This will finish the activity and take you back
    }else{
        //Do whatever it is that you want to do
        return;
    }
}