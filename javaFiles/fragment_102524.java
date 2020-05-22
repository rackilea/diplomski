public enum Animator {

    INSTANCE;

    private Timer timer;

    private List<AnimationProperties> properies;

    private Animator() {
        properies = new ArrayList<>(5);
        timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<AnimationProperties> it = properies.iterator();
                while (it.hasNext()) {
                    AnimationProperties ap = it.next();
                    if (ap.tick()) {
                        it.remove();
                    }
                }
                if (properies.isEmpty()) {
                    timer.stop();
                }
            }
        });
    }

    public void add(AnimationProperties ap) {
        properies.add(ap);
        timer.start();
    }

    public void remove(AnimationProperties ap) {
        properies.remove(ap);
        if (properies.isEmpty()) {
            timer.stop();
        }
    }

}