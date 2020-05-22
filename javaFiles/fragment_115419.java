//assuming that there is some parent class of both classes that contains methods that you would like to use
ObservableListView listView = new ObservableListView(); 
ObservableGridView gridView = new ObservableGridView();

ObservableView view;

if(condition)
{
    view = listView;
}
else
{
    view = gridView;
}

view.someMethod();