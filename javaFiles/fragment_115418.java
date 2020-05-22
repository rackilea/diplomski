//I don't know this object so I'm using a default constructor
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

Method method = obj.getClass().getMethod("methodname", param1.getClass(), param2.getClass());
try
{
    method.invoke(obj, param1, param2);
}catch(Exception e){}