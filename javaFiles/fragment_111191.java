import static org.jfree.ui.TextAnchor.*
…
PolarPlot plot = new PolarPlot() {

    @Override
    protected List refreshAngleTicks() {
        List ticks = new ArrayList();
        ticks.add(new NumberTick(0, "maxCharTick: 20", TOP_LEFT, TOP_LEFT, 0));
        ticks.add(new NumberTick(45, "energyComsuption: 1", TOP_LEFT, TOP_LEFT, 0));
        ticks.add(new NumberTick(90, "maxDamage: 40", TOP_LEFT, TOP_LEFT, 0));
        …
        return ticks;
    }
};