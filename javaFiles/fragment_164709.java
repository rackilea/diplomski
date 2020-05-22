int maxLogStringSize = 1000;
for(int i = 0; i <= veryLongString.length() / maxLogStringSize; i++) {
    int start = i * maxLogStringSize;
    int end = (i+1) * maxLogStringSize;
    end = end > veryLongString.length() ? veryLongString.length() : end;
    Log.v(TAG, veryLongString.substring(start, end));
}