public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {
    Context context; 
    LayoutInflater inflater;
    public CustomInfoWindow(Context context) {
           this.context = context;
    }
    @Override    
    public View getInfoContents(Marker marker) {        
        return null;    
    }
    @Override
    public View getInfoWindow(Marker marker) {
    inflater = (LayoutInflater)
context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  

   // R.layout.custom_info_window is a layout
   // res/layout folder. You can provide your own
    View v = inflater.inflate(R.layout.custom_info_window, null);   

    TextView title = (TextView) v.findViewById(R.id.info_window_title);     
  TextView subtitle = (TextView) v.findViewById(R.id.info_window_subtitle);
    title.setText(marker.getTitle());
    subtitle.setText(marker.getSnippet());
    return v;
    }
}