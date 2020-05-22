increaseButton.setOnClickListener {
        if(seekBar.progress > MAX_LIMIT) {
            seekBar.progress = MAX_LIMIT
            return@setOnClickListener
        }
        if (seekBar.progress == MAX_LIMIT) {
            // you can show notification that you are reach limit
            return@setOnClickListener
        }
        seekBar.progress = seekBar.progress + 1
    }