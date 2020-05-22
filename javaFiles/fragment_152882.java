class Test implements Closeable {

    // reusable PreparedStatements
    private final PreparedStatement updateIdkz;
    private final PreparedStatement updatePersonelId;
    private final PreparedStatement updateBirthDate;

    public Test(Connection con) throws SQLException {
        this.updateIdkz = con
            .prepareStatement("UPDATE Pensionär SET idkz = ?");
        this.updatePersonelId = con
            .prepareStatement("UPDATE Pensionär SET PersNr = ? Where pknr = ?");
        this.updateBirthDate = con
            .prepareStatement("UPDATE Pensionär SET Geburtsdatum = ? Where pknr = ?");
    }

    /** Closes all the prepared statements. */
    @Override
    public void close() throws IOException {
        try {
            updateIdkz.close();
        } catch (SQLException e) {
        }
        try {
            updatePersonelId.close();
        } catch (SQLException e) {
        }
        try {
            updateBirthDate.close();
        } catch (SQLException e) {
        }
    }

    public void addBatchUpdateIdkz(Pensioner p) {
        try {
            updateIdkz.clearParameters();
            updateIdkz.setInt(1, p.getIdkz());
            updateIdkz.addBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBatchUpdatePersonelId(Pensioner p) {
        try {
            updatePersonelId.clearParameters();
            updatePersonelId.setInt(1, p.getPersonelId());
            updatePersonelId.setInt(2, p.getPensionInsuranceNumber());
            updatePersonelId.addBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBatchUpdateBirthDate(Pensioner p) {
        try {
            updateBirthDate.clearParameters();
            updateBirthDate.setDate(1, Date.valueOf(p.getBirthDate()));
            updateBirthDate.setInt(2, p.getPensionInsuranceNumber());
            updateBirthDate.addBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeBatchUpdateIdkz() throws SQLException {
        updateIdkz.executeBatch();
    }

    public void executeBatchUpdatePersonelId() throws SQLException {
        updatePersonelId.executeBatch();
    }

    public void executeBatchUpdateBirthDate() throws SQLException {
        updateBirthDate.executeBatch();
    }

    public static void main(String[] args) {

        Pensioner p1 = null, p2 = null, p3 = null, p4 = null;
        Connection con = null;

        // try with resources to ensure you close the prepared statements
        try (Test t = new Test(con);) {
            // Update multiple Idkz
            t.addBatchUpdateIdkz(p1);
            t.addBatchUpdateIdkz(p2);
            t.addBatchUpdateIdkz(p3);
            t.addBatchUpdateIdkz(p4);
            t.executeBatchUpdateIdkz();

            // Update multile PersonelId
            t.addBatchUpdatePersonelId(p1);
            t.addBatchUpdatePersonelId(p2);
            t.addBatchUpdatePersonelId(p3);
            t.addBatchUpdatePersonelId(p4);
            t.executeBatchUpdatePersonelId();

            // etc...
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}