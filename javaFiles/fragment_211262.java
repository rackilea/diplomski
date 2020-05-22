@Override
    public void writeToParcel(Parcel dest, int flags) {    
        dest.writeString(mTitleError);
        dest.writeString(mDescriptionError);
        Exception[] exceptions = new Exception[1];
        exceptions[0] = mExceptionError;
        dest.writeArray(exceptions);
    }

public ReportErrorVO(Parcel in) {
        mTitleError = in.readString();
        mDescriptionError = in.readString();
        Object[] exceptions = in.readArray(Exception.class.getClassLoader());
        mExceptionError = (Exception) exceptions[0];
    }