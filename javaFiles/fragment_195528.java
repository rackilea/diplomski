public class MainActivity extends Activity {
    private Items[] items = new Items[0]; //We're making this a field, so we can create a new array containing our new item.
    ...
    public void create (String str, Switch sw1) {
        int i = items.length+1; //plus one because we are adding one element at a time. If you'd like to add more at once, change the 1 accordingly.
        Items[] tmp = new Items[i];
        System.arrayCopy(items, 0, tmp, 0, items.length);
        tmp[i] = new Items(str, sw1);
        items = tmp; //use items like you would use Items_data
        ...
    }
}