fixtureSearch.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchTerm = opponentName.getText().toString();
                    dbHelper.deleteMatch(searchTerm);
                }
                }
    );