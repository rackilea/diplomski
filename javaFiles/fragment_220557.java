final class ClickAmountEffectStatic
        implements IResearchEffect {

    final long amount = Long.valueOf(0);

    @Override
    public long getValue() {
        return amount;
    }

}