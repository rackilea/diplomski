import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class ItemListAdapter extends ArrayAdapter<Item> {


    public ItemListAdapter(Context context, int resource) {
        super(context, resource, SettingsStorage.getInstance().getItems());
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        final Item item = getItem(position);
        LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getClickListener() != null) {
                    item.getClickListener().onClick();
                }
            }
        });

        return convertView;
    }

    public interface ClickListener {
        void onClick();
    }
}