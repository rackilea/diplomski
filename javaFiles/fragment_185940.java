cardView.setVisibility(View.GONE);
            for (int i = 0;i<mMyEventsList.size();i++){
                if (mMyEventsList.get(i).getEventTitle().equals(repo.getTitle()) ) {
                    cardView.setVisibility(View.VISIBLE);
                    break;
                }
            }