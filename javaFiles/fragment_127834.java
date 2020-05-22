public final static int RESUMESTATE_NOTHING = 0;
public final static int RESUMESTATE_PRODUCTUSAGEEDIT = 1;
public final static String[] RESUMESTATE_DESCRIPTIONS = {"Nothing","ProductUsageEdit"};

public int resume_state = RESUMESTATE_NOTHING;
public long currentshopid = -1;
public long currentaisleid = -1;
public ProductsPerAisleCursorAdapter currentppaca;

protected void onResume() {
    super.onResume();
    Log.i(Constants.LOG," onResume invoked in " + THIS_ACTIVITY + "-  Current State=" + resume_state + "-"+RESUMESTATE_DESCRIPTIONS[resume_state]);
    switch (resume_state) {
        case RESUMESTATE_NOTHING: {
            break;
        }
        case RESUMESTATE_PRODUCTUSAGEEDIT: {
            Cursor csr = shopperdb.getProductsperAisle(currentaisleid);
            currentppaca.swapCursor(csr);
            resume_state = RESUMESTATE_NOTHING;
            break;
        }
    }
}