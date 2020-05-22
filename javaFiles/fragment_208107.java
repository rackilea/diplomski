public class ImageAdapter extends ArrayAdapter<String> {
    //some declaration and variables here

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        String imagetext = getItem(position); // returns the caption at index
        if (convertView == null) {
            //some stuff here
        }

        //some stuff here
        return v;
    }
}