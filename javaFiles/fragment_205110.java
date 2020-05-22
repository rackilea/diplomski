public final class Table {

    // ===== DECLARE YOUR INSTANCES HERE =====

    static public final AppointmentTable Appointment = new AppointmentTable();
    // static public final FooTable Foo = new FooTable();

    // =======================================

    static private abstract class TableImpl {
        public abstract String getTableName();
        public String toString() { return getTableName(); }
    }

    // ==== DECLARE YOUR DEFINITIONS BELOW ====

    static public class AppointmentTable extends TableImpl {
        public final String ID = "appointmentId";
        // public final <type> <columnName> = <dbFieldName>;

        public String getTableName() { return "appointment"; }
        private AppointmentTable() {}
    }

    // static public class FooTable extends TableImpl { ... }

}