switch (mRace.getRaceState()) {

        case RUNNING:
            mRace.update(delta, 1);
            if (enemyReference.canSpawnNewLine() && enemyReference.getY() < 350) {
                enemyReference.setCanSpawnNewLine(false);
                spawnNewLine();
            }
            // This handle the removing
            if (enemiesRef.get(0).getEnd() <= 0) {
                mRenderer.removeFirst();
                enemiesRef.remove(0);
            }
            break;

    }