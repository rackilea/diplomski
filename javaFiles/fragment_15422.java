public void moveFirebaseRecord(Firebase fromPath, final Firebase toPath)
{
    fromPath.addListenerForSingleValueEvent(new ValueEventListener()
    {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot)
        {
            toPath.setValue(dataSnapshot.getValue(), new Firebase.CompletionListener()
            {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase)
                {
                    if (firebaseError != null)
                    {
                        System.out.println("Copy failed");
                    }
                    else
                    {
                        System.out.println("Success");
                    }
                }
            });
        }

        @Override
        public void onCancelled(FirebaseError firebaseError)
        {
            System.out.println("Copy failed");
        }
    });
}