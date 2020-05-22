decreaseButton.setOnClickListener {
        if(seekBar.progress < MIN_LIMIT) {
            seekBar.progress = MIN_LIMIT
            return@setOnClickListener
        }
        if (seekBar.progress == MIN_LIMIT) {
            // you can show notification that you are reach limit
            return@setOnClickListener
        }
        seekBar.progress = seekBar.progress - 1
    }