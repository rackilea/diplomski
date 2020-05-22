databaseTenants.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tenants.clear();

                for(DataSnapshot tenantSnapshot : dataSnapshot.getChildren()){ 
                    for(DataSnapshot lastSnapshot: tenantSnapshot.getChildren()){ 
                       Tenant tenant = lastSnapshot.getValue(Tenant.class); 
                       tenants.add(tenant); 
                    } 
                 } 
               tenantListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });