marquee()
    .text("Play")
    .location(x, y)
    .position(libvlc_marquee_position_e.bottom)
    .opacity(0.7f)
    .colour(Color.white)
    .timeout(5000)
    .size(20)
    .apply(mediaPlayer);