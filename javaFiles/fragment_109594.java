final List<Tab> result = ...; // your tab list

// number of elements added each frame
final int step = 5;

final int size = result.size();
AnimationTimer timer = new AnimationTimer() {

    int index = 0;

    @Override
    public void handle(long now) {
        tabPane.getTabs().addAll(result.subList(index, Math.min(size, index+step)));
        index += step;
        if (index >= size) {
            this.stop();
        }
    }
};
timer.start();