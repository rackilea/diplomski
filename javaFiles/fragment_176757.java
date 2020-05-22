long sum = 0;
 for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
 long size = dataSnapshot1.getChildrenCount();
 sum += size;
 holder.getTextViewPostThreadsCount().setText("Jumlah Pos: " + size);

        }