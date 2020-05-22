public class DoctorsCatAdapter extends RecyclerView.Adapter<DoctorsCatAdapter.MyViewHolder> {
    ArrayList <DoctorsCatPojo> doctorCatList;
    Context context;

    public DoctorsCatAdapter( Context context,ArrayList<DoctorsCatPojo> doctorCatList) {
         this.doctorCatList = doctorCatList;
        this.context= context;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_category_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DoctorsCatPojo doc = doctorCatList.get(position);
      //  holder.doctorsCatImg.setImageURI(doc.getCategory_img());



        if(doc.getCategory_name()!=null){
            holder.doctorsCatName.setText(doc.getCategory_name());
        }
        if(doc.getCategory_img()!=null){
            Picasso.with(context)
                    .load(doc.getCategory_img().replace(" ", "%20").trim())
                    .placeholder(R.drawable.no_image)
                    .into(holder.doctorsCatImg);

        }








    }

    @Override
    public int getItemCount() {
        return doctorCatList.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         ImageView doctorsCatImg;
         TextView doctorsCatName;

         MyViewHolder(final View view) {
            super(view);
            itemView.setOnClickListener(this);

            doctorsCatImg = (ImageView)view.findViewById(R.id.doctorsCatImg);
            doctorsCatName = (TextView) view.findViewById(R.id.doctorsCatName);

        }


         @Override
         public void onClick(View view) {
             doctorCatList.get(getPosition()).getCategory_id();
             ((DoctorHome)context).callDoctorListActivity(doctorCatList.get(getPosition()).getCategory_id(),doctorCatList.get(getPosition()).getCategory_name());
         }
     }
}