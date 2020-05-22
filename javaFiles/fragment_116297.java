db.beginTransaction();
.
.
db.setTransactionSuccessful();
} catch (SQLException e) {
} finally {
       db.endTransaction();
}