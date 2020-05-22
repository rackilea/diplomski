public class WordAdapter extends ArrayAdapter<Word> {
private int mColorResourceId;
private Context mContext;

public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
    super(context, 0, words);
    mColorResourceId = colorResourceId;
    mContext = context;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);
    }

    final Word currentWord = getItem(position);

    TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
    miwokTextView.setText(currentWord.getMiwokTranslationId());

    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
    defaultTextView.setText(currentWord.getDefaultTranslationId());

    TextView onClickTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view_on_click);

    onClickTextView.setText((currentWord.getTextOnClickId()));

    final ImageView playIcon = (ImageView) listItemView.findViewById(R.id.play_icon);
    final ImageView playIconPlaying = (ImageView) listItemView.findViewById(R.id.play_icon_playing);

    final ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);


    if (currentWord.hasImage()) {
        imageView.setImageResource(currentWord.getImageResourceId());
        imageView.setVisibility(View.VISIBLE);
    } else {
        imageView.setVisibility(View.GONE);
    }

    if (mContext.getClass().getSimpleName().equalsIgnoreCase("Activity1") || mContext.getClass().getSimpleName().equalsIgnoreCase("Activity3")) {
        onClickTextView.setTextSize(55);
    } else {
        onClickTextView.setTextSize(35);
    }


    imageView.setTag(position);

    View textContainer = listItemView.findViewById(R.id.text_container);
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    textContainer.setBackgroundColor(color);


    imageView.setOnClickListener(new ImageView.OnClickListener() {
        @Override
        public void onClick(View view) {


            if (currentWord.isFlag) {
                currentWord.isFlag = false;
                Word.flaggedPosition = -1;
            } else {
                if (Word.flaggedPosition >= 0) {
                    Word.adapter.getItem(Word.flaggedPosition).isFlag = false;
                }
                currentWord.isFlag = true;
                Word.flaggedPosition = position;
            }
            notifyDataSetChanged();
        }

    });

    if (currentWord.isFlag) {

        imageView.setAlpha(60);
        onClickTextView.setVisibility(View.VISIBLE);
    } else {
        imageView.setAlpha(255);
        onClickTextView.setVisibility(View.INVISIBLE);
    }

    return listItemView;
   }
}