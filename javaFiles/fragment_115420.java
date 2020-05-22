//this assumes that both ObservableListView and ObservableGridView implement some interface 'IObservableView'
ObservableListView listView = new ObservableListView(); 
ObservableGridView gridView = new ObservableGridView();

IObservableView view;

if(condition)
{
    view = listView;
}
else
{
    view = gridView;
}

view.someMethod();