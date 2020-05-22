public class Loop implements Observer {

    Connect connect;

    public Loop() {
        connect = new Connect(this);
    }

    // Called when notifyObservers() is fired
    @Override
    public void update(Observable o, Object arg) {
        Connect connect = (Connect) o;
        try {
            if(connect.conn.isClosed()) {
                // --------
            } else {
                // --------
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}