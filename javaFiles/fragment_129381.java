queryInProgress.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                queryTask.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //adding the key to an Arraylist to be referenced when deleting records
                    filteredbyInProgress.add(ds.getKey());
                    String name = ds.child("Name").getValue(String.class);

                    if (!queryTask.contains(value)) {
                      queryTask.add(value);
                    }
                }

                task_list.this.dbTasks.setAdapter(filterAdapter4);
                filterAdapter4.notifyDataSetChanged();
                arrayAdapter4.clear();
                arrayAdapter4.notifyDataSetChanged();
            }