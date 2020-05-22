private MutableLiveData<ArrayList<ClassModel>> mutableClassModels = new MutableLiveData<>();
private ArrayList<ClassModel> classModels = new ArrayList<>();

public MutableLiveData<ArrayList<ClassModel>> getClassesList(){//upto to this every thing execute but from here the //execution jumps to if(condition) line below...and I get null arraylist in return

    FbDb.child("Classes").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for(DataSnapshot ds: dataSnapshot.getChildren())
            {
                ClassModel classModel = ds.getValue(ClassModel.class);
                classModels.add(classModel);
                Log.i("Tag", "Msg");
            }

            mutableClassModels.postValue(classModels);
            Log.i("Tag", String.valueOf(classModels.size()));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

    return mutableClassModels;
}