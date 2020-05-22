long start = SystemClock.elapsedRealtime();

    int lineCount = 0;
    try (InputStream in = getResources().openRawResource(R.raw.fl_insurance_sample)) {

        int index = 0;
        int charCount = 0;
        int cIn;
        while ((cIn = in.read()) != -1) {
            charCount++;

            char ch = (char) cIn;  // this was for debugging
            if (ch == '\n' || ch == '\r') {
                lineCount++;
                if (lineCount % MULTIPLE == 0) {
                    index = lineCount / MULTIPLE;
                    if (index == mLines.length) {
                        mLines = Arrays.copyOf(mLines, mLines.length + 100);
                    }
                    mLines[index] = charCount;
                }
            }

        }

        mLines = Arrays.copyOf(mLines, index+1);

    } catch (IOException e) {
        Log.e(TAG, "error reading raw resource", e);
    }

    long elapsed = SystemClock.elapsedRealtime() - start;