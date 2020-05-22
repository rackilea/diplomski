long time = 0;
for (int iii = 0; iii < pathGeometries.size(); iii++) {
    final int counter = iii;
    time += 1000;
    EventDetail.handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            moveNext(pathGeometries.get(counter).getX(),
                    pathGeometries.get(counter).getY(), 0, d);
        }
    }, time);
}