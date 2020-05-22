userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getTopThreeUsers((Map<String, Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

private void getTopThreeUsers(Map<String, Object> users) {
        HashMap<String, Long> namesAndScores = new HashMap<>();
        for (Map.Entry<String, Object> entry : users.entrySet()) {
            Map singleUser = (Map) entry.getValue();
            namesAndScores.put((String) singleUser.get("name"), (Long) singleUser.get("userScore"));
        }
        Set<Map.Entry<String, Long>> set = namesAndScores.entrySet();
        List<Map.Entry<String, Long>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        topName1.setText(list.get(0).getKey());
        topName2.setText(list.get(1).getKey());
        topName3.setText(list.get(2).getKey());

        topScore1.setText(String.valueOf(list.get(0).getValue()));
        topScore2.setText(String.valueOf(list.get(1).getValue()));
        topScore3.setText(String.valueOf(list.get(2).getValue()));
    }