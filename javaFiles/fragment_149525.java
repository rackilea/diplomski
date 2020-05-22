public class ItemObject {

    private List<IdSoal> id_soal = null;
    private Integer success;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<IdSoal> getIdSoal() {
        return id_soal;
    }

    public void setIdSoal(List<IdSoal> idSoal) {
        this.id_soal = idSoal;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}