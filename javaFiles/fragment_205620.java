import android.content.Context;
 import android.content.Intent;
 import android.net.Uri;
 import android.support.design.widget.FloatingActionButton;
 import android.support.v4.content.ContextCompat;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.ImageView;
 import android.widget.TextView;
 import java.util.ArrayList;

  public class WordAdapter extends ArrayAdapter<Word>  {
private int mColorResourceId;
private Context context;


public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
    super(context, 0, words);
    mColorResourceId = colorResourceId;
    this.context = context;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);
    }



    Word currentWord = getItem(position);

    TextView SaudiTextView = (TextView) listItemView.findViewById(R.id.s_text_view);

    SaudiTextView.setText(currentWord.getsTranslationId());

    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

    defaultTextView.setText(currentWord.getDefaultTranslationId());

    FloatingActionButton fab = (FloatingActionButton) listItemView.findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("https://www.facebook.com"); 
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }
    });

    ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

    if (currentWord.hasImage()) {
        imageView.setImageResource(currentWord.getImageResourceId());
        imageView.setVisibility(View.VISIBLE);
    } else {
        imageView.setVisibility(View.GONE);
    }

    View textContainer = listItemView.findViewById(R.id.text_container);

    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    textContainer.setBackgroundColor(color);

    return listItemView;

}
}