if (loadPlayerScoreResult.getScore() != null) {
                        Games.Leaderboards.submitScore(getApiClient(),
                                getString(R.string.poeni_tabela),
                                loadPlayerScoreResult.getScore().getRawScore()
                                        + points);
                    } else {
                        Games.Leaderboards.submitScore(getApiClient(),
                                getString(R.string.poeni_tabela), points);
                    }