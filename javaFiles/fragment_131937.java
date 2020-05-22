public class ManageChallenge {

    @SerializedName("success")
    private String success;

    @SerializedName("result")
    private GetChallengeList result;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public GetChallengeList getResult() {
        return result;
    }

    public void setResult(GetChallengeList result) {
        this.result = result;
    }
}