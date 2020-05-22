if (visualize[k][l] == 2 && (alive == 2 || alive == 3)) {
                // Live cell stays alive if 2 or 3 neighbours
                life[k][l] = 2;
            }
            else if (visualize[k][l] == 1 && alive == 3) {
                // Dead cell becomes live if 3 neighbours
                life[k][l] = 2;
            }
            else {
                // Anything else: cell either dies or stays dead.
                life[k][l] = 1;
            }