public class Example {
    private String var1 = "Something";

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        // TODO: null guards
        if (var1.equals(this.var1)) {
            // No-op - no need to do anything
            return;
        }
        this.var1 = var1;
        notifyListenersOfChangeToVar1();
    }
}