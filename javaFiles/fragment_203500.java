//Initialize it, as it causing NullPointerException
ArrayList<ClassModel> clsList = new ArrayList<>();

public Adapter(Context context, String name) {

    ...

    DbOnline=new Firebase_Database();
    if (fragName.equals(listForClasses)) {
        DbOnline.getClassesList().observe((LifecycleOwner) context, new Observer<ArrayList<ClassModel>>() {
            @Override
            public void onChanged(ArrayList<ClassModel> classModels) {
                clsList =classModels;
                clsList.size();

                //Notify to refresh the items
                notifyDataSetChanged();
            }
            });
    } else {
        sList = null;//DbOffline.getStudentsList("");
    }
}