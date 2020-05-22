// An attribute to trigger default back pressed behaviour
protected boolean actionDone = false;

// use this to set actionDone to true, when whatever action it may be is triggered
public void onSomeActionDone()
{
    actionDone = true;
}

@ Override
public void onBackPressed()
{
    if (actionDone){ // use default onBackPressed behaviour, going up the navigation or exiting the app
        super.onBackPressed ();
    } else {
        // do nothing, maybe fire a toast saying: "cant go back"
    }
}