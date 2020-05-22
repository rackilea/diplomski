public class TimeTableForBus  {

        String bsName;
        int bsType;
        Time ttTime;
        int lon;
        int lat;
        int ttID;
        int bus_stop_status;

        @Override
        public int hashCode() {
            int result = 31;

            result = 37 * result + generateHash(bsName);
            result = 37 * result + generateHash(bsType);
            result = 37 * result + generateHash(ttTime);
            result = 37 * result + generateHash(lon);
            result = 37 * result + generateHash(lat);
            result = 37 * result + generateHash(ttID);
            result = 37 * result + generateHash(bus_stop_status);

            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof TimeTableForBus))
                return false;
            TimeTableForBus model = (TimeTableForBus)o;
            return Objects.equals(bsName, model.bsName)
                    && bsType == model.bsType
                    && Objects.equals(ttTime, model.ttTime)
                    && lon == model.lon
                    && lat == model.lat
                    && ttID == model.ttID
                    && bus_stop_status == model.bus_stop_status;
        }

        private int generateHash(long value) {
            return (int)(value ^ (value >>> 32));
        }

        private int generateHash(Object value) {
            return value == null ? 0 : value.hashCode();
        }

    }