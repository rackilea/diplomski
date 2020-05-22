public class ApiError {
@SerializedName("error")
private String mErrorDescription;

@SerializedName("code")
private Integer mErrorCode;

public ApiError() {}

public void setErrorCode(Integer code) {
    this.mErrorCode = code;
}

public Integer getErrorCode() {
    return mErrorCode;
}

public String getErrorDescription() {
    return mErrorDescription;
}

public void setErrorDescription(String errorDescription) {
    mErrorDescription = errorDescription;
}