public int getCandleSize() {
    if(lengte > 15)
        lengte -= speed;
    else
        autoburn.stop();

    return lengte;
}