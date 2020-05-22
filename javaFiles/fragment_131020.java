@Embeddable
public class EmMonthlyPollTablesEntityPK implements Serializable {

    @Column(name = "MONTHLY_POLL_ID", nullable = false)
    private int monthlyPollId;

    @Column(name = "TABLE_ID", nullable = false)
    private int tableId;

    public EmMonthlyPollTablesEntityPK() {
    }

    public EmMonthlyPollTablesEntityPK(int monthlyPollId, int tableId) {
        this.monthlyPollId = monthlyPollId;
        this.tableId = tableId;
    }

    public int getMonthlyPollId() {
        return monthlyPollId;
    }

    public void setMonthlyPollId(int monthlyPollId) {
        this.monthlyPollId = monthlyPollId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmMonthlyPollTablesEntityPK that = (EmMonthlyPollTablesEntityPK) o;
        return monthlyPollId == that.monthlyPollId && tableId == that.tableId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyPollId, tableId);
    }
}