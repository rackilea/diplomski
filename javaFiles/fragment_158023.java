public interface BoolOp {
    public boolean TruthValue(boolean x, boolean z);
}
...
public void performBoolOp (BoolOp op) {
    op.TruthValue(true, true);
}
...
performBoolOp((x, z) -> !x^z);