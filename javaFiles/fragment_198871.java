@Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
                    {
                        Question ques = postSnapshot.getValue(Question.class);
                        Common.questionList.add(ques);
                    }
                    // Shuffle it
                    Collections.shuffle(Common.questionList);

                }