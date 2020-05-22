import java.util.Comparator;

    class Compareid implements Comparator<Flight> {
        public int compare(Flight flightObject1, Flight flightObject2) {
            return (flightObject1.flightName.compareTo(flightObject2.flightName));

        }
    }