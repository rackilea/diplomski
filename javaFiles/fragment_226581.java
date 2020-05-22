class SingleTonBillPaugh$SingleTonHelper {
  private static final SingleTonBillPaugh instance;

  SingleTonBillPaugh$SingleTonHelper();
    Code:
       0: aload_0
       1: invokespecial #2                  // Method java/lang/Object."<init>":()V
       4: return

  static SingleTonBillPaugh access$000();
    Code:
       0: getstatic     #1                  // Field instance:LSingleTonBillPaugh;
       3: areturn

  static {};
    Code:
       0: new           #3                  // class SingleTonBillPaugh
       3: dup
       4: aconst_null
       5: invokespecial #4                  // Method SingleTonBillPaugh."<init>":(LSingleTonBillPaugh$1;)V
       8: putstatic     #1                  // Field instance:LSingleTonBillPaugh;
      11: return
}