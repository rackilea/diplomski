//notice now myCustomClass is implemented as a type of "OnNavigationItemSelectedListener" (the implements keyword)
//according to https://developer.android.com/reference/android/support/design/widget/NavigationView.OnNavigationItemSelectedListener.html
//all implementation of OnNavigationItemSelectedListener requires 
//a method called "onNavigationItemSelected" -> so we add that in too.
public MyCustomClass implements NavigationView.OnNavigationItemSelectedListener{

    public void someMethods(){

        //...setting the argument to "this", means when the navigation item is selected,
        //the method onNavigationItemSelected in "MyCustomClass" will be called
        navigationView.setNavigationItemSelectedListener(this);

    }

    //this method will be called whenever navigationItem is selected
    boolean onNavigationItemSelected(MenuItem item){
       //you will do your coding on what to do when an navigationItem is selected here.
    }

}