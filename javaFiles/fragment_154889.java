Button button = new Button(this);
            button.setText("Pause");
            button.setId(1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    togglePausePlay();
                }
            });
            menuLayout.addView(button);

private void togglePausePlay() {
        if (cg.paused) {
            // play and change text to pause
            button.setText("Pause")
            cg.paused = false;
        } else {
            // pause and change text to play
            button.setText("Play")
            cg.paused = true;
        }

    }