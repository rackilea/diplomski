case R.id.highest_rated:
//Clear the adapter whenever this highest rated movie is clicked
                movieAdapter.clear(); //Clear the adapter whenever this highest rated movie is clicked
                setFavorite(false);
                setTopRated(true);

                movieAdapter.notifyDataSetChanged();
                context = MainActivity.this;
                textToShow = "Sorted by rate";
                Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
                break;