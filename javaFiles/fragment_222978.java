import android.content.Context;    
import android.support.annotation.NonNull;    
import android.view.LayoutInflater;    
import android.view.View;    
import android.view.ViewGroup;    
import android.widget.ArrayAdapter;    
import android.widget.TextView;            
import java.util.ArrayList;

public class CustomLocationAdapter  extends ArrayAdapter<Location> {

    public CustomLocationAdapter(@NonNull Context context, ArrayList<Location> locations) {
        super(context,0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Location location = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_location, parent, false);
        }
        // Lookup view for data population
        TextView tvAddressLocality = (TextView) convertView.findViewById(R.id.tvaddressLocality);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
        // Populate the data into the template view using the data object
        tvAddressLocality.setText(location.getAddressLocality());
        tvName.setText(location.getName());
        tvAddress.setText(location.getAddress());
        // Return the completed view to render on screen
        return convertView;
    }
}