private void commonLogic(Runnable action)
{
    if(nullCheckStuff) {
        action.run();
    } else {
        //log error
    }
}