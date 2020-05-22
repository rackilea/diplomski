int index = 0;
        while ((line = buffRdr.readLine()) != null) {
            String[] lnPtr = line.split(",", NUM_OF_COL);
            int diff = Math.min(lnPtr.length, NUM_OF_COL);
            for (int i = 0; i < diff; i++) {
                if ((index == GENRE_1) && !lnPtr[i].isEmpty()) {
                    actionMovies.add(lnPtr[i]);
                } else if ((index == GENRE_2) && !lnPtr[i].isEmpty()) {
                    dramaMovies.add(lnPtr[i]);
                } else if ((index == GENRE_3) && !lnPtr[i].isEmpty()) {
                    sciFiFantasyMovies.add(lnPtr[i]);
                } else if ((index == GENRE_4) && !lnPtr[i].isEmpty()) {
                    thrillerSuspenseMovies.add(lnPtr[i]);
                } else if ((index == GENRE_5) && !lnPtr[i].isEmpty()){
                    comedyMovies.add(lnPtr[i]);
                }
            }
            index++;
        }