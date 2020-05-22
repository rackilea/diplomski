//very flexible version. I think that this is the route I would choose
ObservableListView listView = new ObservableListView(); 
ObservableGridView gridView = new ObservableGridView();

Object obj;

if(condition)
{
    obj = listView;
}
else
{
    obj = gridView;
}

if(obj instanceof ObservableListView)
{
    ((ObservableListView)obj).someMethodOnlyInThisClass();
}
else if(obj instanceof ObservableGridView)
{
    ((ObservableGridView)obj).someOtherMethodOnlyInThisClass();
}