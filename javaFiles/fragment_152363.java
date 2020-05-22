protected void onCreate(android.os.Bundle);
    Code:
       0: aload_0
       1: aload_1
       2: invokespecial #20                 // Method android/app/Activity.onCreate:(Landroid/os/Bundle;)V
       5: aload_0
       6: ldc           #21                 // int 2130903040
       8: invokevirtual #25                 // Method setContentView:(I)V
      11: aload_0
      12: ldc           #26                 // int 2131230720
      14: invokevirtual #30                 // Method findViewById:(I)Landroid/view/View;
      17: checkcast     #32                 // class android/widget/TextView
      20: astore_1
      21: aload_1
      22: getstatic     #12                 // Field count:I
      25: invokestatic  #38                 // Method java/lang/Integer.toString:(I)Ljava/lang/String;
      28: invokevirtual #42                 // Method android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
      31: aload_0
      32: ldc           #43                 // int 2131230721
      34: invokevirtual #30                 // Method findViewById:(I)Landroid/view/View;
      37: checkcast     #45                 // class android/widget/Button
      40: new           #6                  // class com/example/test/MainActivity$1
      43: dup
      44: aload_0
      45: aload_1
      46: invokespecial #48                 // Method com/example/test/MainActivity$1."<init>":(Lcom/example/test/MainActivity;Landroid/widget/TextView;)V
      49: invokevirtual #52                 // Method android/widget/Button.setOnClickListener:(Landroid/view/View$OnClickListener;)V
      52: return