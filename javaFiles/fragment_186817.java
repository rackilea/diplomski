ArrayList<ImageView> imageList=new ArrayList<ImageView>();
ArrayList<Integer> idList=new ArrayList<Integer>();
LinearLayout ll;

ll=(LinearLayout)findViewById(R.id.layout);

for(int i=0;i<ll.getChildCount();i++){
        View v=ll.getChildAt(i);
        if(v instanceof ImageView){
            imageList.add((ImageView)v);
            idList.add(v.getId());
        }
 }