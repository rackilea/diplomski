public class ScanResult implements Parcelable {

    public String contents;
    public String formatName;
    public byte[] rawBytes;
    public Integer orientation;
    public String errorCorrectionLevel;

    public ScanResult(IntentResult intentResult) {
        contents = intentResult.getContents();
        formatName = intentResult.getFormatName();
        rawBytes = intentResult.getRawBytes();
        orientation = intentResult.getOrientation();
        errorCorrectionLevel = intentResult.getErrorCorrectionLevel();
    }

    protected ScanResult(Parcel in) {
        contents = in.readString();
        formatName = in.readString();
        rawBytes = in.createByteArray();
        long orientationInLong = in.readLong();
        orientation = orientationInLong != Long.MAX_VALUE ? (int) orientationInLong : null;
        errorCorrectionLevel = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contents);
        dest.writeString(formatName);
        dest.writeByteArray(rawBytes);
        dest.writeLong(orientation != null ? orientation : Long.MAX_VALUE);
        dest.writeString(errorCorrectionLevel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScanResult> CREATOR = new Creator<ScanResult>() {
        @Override
        public ScanResult createFromParcel(Parcel in) {
            return new ScanResult(in);
        }

        @Override
        public ScanResult[] newArray(int size) {
            return new ScanResult[size];
        }
    };
}