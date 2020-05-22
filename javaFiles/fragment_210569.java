public class Services {
    public List<ServiceItem> services;
    public Status status;
    // getters and setters
    @Override
    public String toString() {
        return "["+services.toString()+status.toString()+"]";
    }

    public class ServiceItem {
        public int id;
        public String name;
        // getters and setters
        @Override
        public String toString() {
            return "("+id+","+name+")";
        }

    }

    public class Status {
        public int code;
        public String message;
        // getters and setters
        @Override
        public String toString() {
            return ",("+code+","+message+")";
        }
    }
}