ValueEventListener mQuestionsListener = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Question ques = postSnapshot.getValue(Question.class);
                        Common.questionList.add(ques);
                    }
                    //Random List
                    Collections.shuffle(Common.questionList);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });