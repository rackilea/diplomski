public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

       String[] values;
       Context context1;
       private LocaleListener mListener;  //some change here

       public RecyclerViewAdapter(Context context2,String[] values2){

           values = values2;

           context1 = context2;
       }

       public static class ViewHolder extends RecyclerView.ViewHolder{

           public TextView textView;

           public ViewHolder(View v){

               super(v);

               textView = (TextView) v.findViewById(R.id.textview1);

           }
      }

     @Override
     public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

         View view1 = LayoutInflater.from(context1).inflate(R.layout.recycler_view_items,parent,false);

         ViewHolder viewHolder1 = new ViewHolder(view1);

         return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder,final int position){

        Vholder.textView.setText(values[position]);

        Vholder.textView.setBackgroundColor(Color.parseColor("#ffc947"));

       Vholder.textView.setTextColor(Color.BLACK);
       Vholder.textView.setBackgroundResource(R.drawable.rounded_corner);

       Vholder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(position == 4 && mListener != null){ // some change here
                   mListener.setLocale("hi");//calling function
               }
           }
       });

      }

    @Override
    public int getItemCount(){

        return values.length;
    }

    //some change here
    public void setLocaleListener(LocaleListener listener) {
        mListener = listener
    }
}