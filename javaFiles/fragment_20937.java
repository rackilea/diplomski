while (1) {
    bool btop = pos.y >= top
    bool bbottom = pos.y <= bottom
    bool bleft = pos.x <= left
    bool bright = pos.x >= right
    bool rect_btop = pos.y <= rect_top && pos.x >= rect_left && pos.x <= rect_right
    bool rect_bbottom = pos.y <= rect_bottom && pos.x >= rect_left && pos.x <= rect_right
    bool rect_bright = pos.x <= rect_right && pos.y >= rect_bottom && pos.y <= rect_top
    bool rect_bleft = pos.x >= rect_left && pos.y >= rect_bottom && pos.y <= rect_top

    if (btop || bottom || rect_btop || rect_bbottom)
        vy -= vy

    if (bleft || bright || rect_bleft || rect_bright)
        vx -= vx
}