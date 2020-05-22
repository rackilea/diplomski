int indexA = 0;
    int indexB = 0;
    while (indexA < liczbyPierwszeA.size () && indexB < liczbyPierwszeB.size()) {
        if (liczbyPierwszeA.get(indexA) == liczbyPierwszeB.get(indexB)) {
            Wspolne.add(WspolneLicznik, liczbyPierwszeA.get(indexA));
            indexA++;
            indexB++;
            WspolneLicznik++; // not sure what this counter is for. I kept it just 
                              // in case it's needed
        } else {
            if (iczbyPierwszeA.get(indexA) < liczbyPierwszeB.get(indexB))
                indexA++;
            else
                indexB++;
        }
    }