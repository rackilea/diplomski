public class GameViewAdapter extends RecyclerView.Adapter<GameViewAdapter.GameViewHolder> {

    private ArrayList<GameItem> mGameList;
    private OnItemClickListener mListener;

    public GameViewAdapter(ArrayList<GameItem> mGameList, GameViewAdapter.OnItemClickListener mListener) {
        this.mGameList = mGameList;
        this.mListener = mListener;
    }

    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.game_entry, viewGroup, false);
        GameViewHolder GVH = new GameViewHolder(v, mListener);
        return GVH;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder gameViewHolder, int position){
        gameViewHolder.bind(mGameList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemCover;
        private TextView itemTitle;
        private TextView itemDescription;
        private PopupWindow popupWindow;
        private ImageView popUpImage;
        private TextView PopUpTitle;
        private EditText customAmount;
        private Button add;
        private Button addcustom;
        private Button exit;

        public GameViewHolder(View itemView, GameViewAdapter.OnItemClickListener mListener) {
            super(itemView);
            setupViews(itemView);
        }

        public void bind(GameItem gameItem) {
            Glide.with(this.itemCover).load(gameItem.getCover()).into(this.itemCover);
            this.itemTitle.setText(gameItem.getTitle());
            this.itemDescription.setText(gameItem.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopUp(itemView, gameItem);
                }
            });
        }

        private void setupViews(View itemView) {
            add = itemView.findViewById(R.id.addaverage);
            addcustom = itemView.findViewById(R.id.addcustom);
            popUpImage = itemView.findViewById(R.id.popupimg);
            PopUpTitle = itemView.findViewById(R.id.popuptitle);
            customAmount = itemView.findViewById(R.id.gameamount);
            itemCover = itemView.findViewById(R.id.GameCover);
            itemTitle = itemView.findViewById(R.id.GameTitle);
            itemDescription = itemView.findViewById(R.id.GameAmount);
            exit = itemView.findViewById(R.id.exit);
        }

        private void showPopUp(View itemView, GameItem gameItem) {
            final View popupView = LayoutInflater.from(itemView.getContext()).inflate(R.layout.popup, null);
            final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

            final ImageView popupItemCover = popupView.findViewById(R.id.popupItemCover);
            final TextView popupItemTitle = popupView.findViewById(R.id.popupItemTitle);

            Glide.with(popupItemCover).load(gameItem.getCover()).into(popupItemCover);
            popupItemTitle.setText(gameItem.getTitle());

            exit = popupView.findViewById(R.id.exit);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
        }

    }

    public interface OnItemClickListener{
        void onGameClick(int position);
    }
}