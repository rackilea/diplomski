private void LoadFragments() {
        mainActiveTools = loadActiveTools();
        frameLayouts = loadFrameLayouts();
        fragments = loadFragments();

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int i = 0;
        while(i != frameLayouts.size()) {
            int currentFrame = frameLayouts.get(i);
            try {
                android.support.v4.app.Fragment currentFrag = fragments.get(i);
                transaction.replace(currentFrame, currentFrag);
                findViewById(currentFrame).setVisibility(View.VISIBLE);
            }
            catch (IndexOutOfBoundsException e) {
                findViewById(currentFrame).setVisibility(View.INVISIBLE);
            }
            i++;
        }
        transaction.commit();
    }