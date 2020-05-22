AnimatorSet as = new AnimatorSet();
as.playSequentially(yourFirstAnim, 
                    yourSecondAnim,
                    ..,
                    ...);
as.setDuration(YOUR_DURATION);
as.start();