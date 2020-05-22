public class Item{
   String url;
   int id;
   boolean link = false;
   boolean resource = false;
   public Item(int id){
       this.id = id;
       resource = true;
   }
   public Item(String url){
       this.url = url;
       link = true;
   }
   public boolean isLink(){
       return link;
   }
   public boolean isResource(){
       return resource;
   }
   public int getId(){
       return id;
   }
   public String getUrl(){
       return url;
   }
}



public class sliderAdapter extends PagerAdapter {

    private Context context;

    private List<Item> items = new ArrayList<>();
    sliderAdapter(Context context, List<Item> items){
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideshow_layout,container,false);
        ImageView img = view.findViewById(R.id.imageview);
        Item item = items.get(position);
        if(item.isLink()){
            Glide.with(context).load(item.getUrl()).into(img);
        }else{
            img.setImageResource(item.getId());
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}