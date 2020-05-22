private final Set<Result> uniqueResults = new HashSet<>();

@Override
public void onResponse(Call<LiveScore> call, Response<LiveScore> response) {
    if (!response.isSuccessful()) {
        Toast.makeText(MainService.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
        return;
    }
    liveScore = response.body();

    for(Result r : response.body().getResult()) {
        if(uniqueResults.add(r)) {
            // notify user
        }
    }

});