Plotter (int dotsPerPx, Canvas canvas_) {
    this.dotsPerPx = dotsPerPx;
    this.canvas = canvas_;
    screenWidth = canvas.getWidth();
}

int dotsPerPx;  //This one sets to 1, as supposed
Canvas canvas;  //And this remains null, though canvas_==openGLCanvas...
int screenWidth;