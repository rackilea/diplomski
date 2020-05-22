@Override
public void copy(ComItem temp) {
    super.copy(temp);
    if (form.getTempObject() instanceof ItemA) {
        this.thingA = ((ItemA) temp).thingA; // <- **NOW NO ERROR**
    }
}