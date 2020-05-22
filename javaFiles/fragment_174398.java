TableLayout PartDetailLayout = ((TableLayout) findViewById(R.id.tblLayoutContent));
        iTableLayout PartDetailLayout = ((TableLayout) findViewById(R.id.tblLayoutContent));
int childParts = PartDetailLayout.getChildCount();
if (PartDetailLayout != null) {
    for (int i = 0; i < childParts; i++) {
        View viewChild = PartDetailLayout.getChildAt(i);
        if (viewChild instanceof TableRow) {
            int rowChildParts = ((TableRow) viewChild).getChildCount();
            for (int j = 0; j < rowChildParts; j++) {
                View viewChild2 = ((TableRow) viewChild).getChildAt(j);
                if (viewChild2 instanceof EditText) {
                    // get text from edit text
                    String text = ((EditText) viewChild2).getText().toString();
                } else if (viewChild2 instanceof TextView) {
                    // get text from text view
                    String text = ((TextView) viewChild2).getText().toString();
                    //TODO: add rest of the logic
                }
            }
        }
    }
}