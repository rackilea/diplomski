import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("card_id")
    @Expose
    private String cardId;
    @SerializedName("t_tasks_e_dic_load_types_sj_id")
    @Expose
    private Integer tTasksEDicLoadTypesSjId;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("eup")
    @Expose
    private String eup;
    @SerializedName("card_nr")
    @Expose
    private String cardNr;
    @SerializedName("change_time")
    @Expose
    private String changeTime;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getTTasksEDicLoadTypesSjId() {
        return tTasksEDicLoadTypesSjId;
    }

    public void setTTasksEDicLoadTypesSjId(Integer tTasksEDicLoadTypesSjId) {
        this.tTasksEDicLoadTypesSjId = tTasksEDicLoadTypesSjId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getEup() {
        return eup;
    }

    public void setEup(String eup) {
        this.eup = eup;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    @Override
    public String toString() {
        return "Example{" +
                "cardId='" + cardId + '\'' +
                ", tTasksEDicLoadTypesSjId=" + tTasksEDicLoadTypesSjId +
                ", statusId=" + statusId +
                ", eup='" + eup + '\'' +
                ", cardNr='" + cardNr + '\'' +
                ", changeTime='" + changeTime + '\'' +
                '}';
    }
}