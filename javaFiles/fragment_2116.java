public class IPAddress {

        private IPOctet octet1;
        private IPOctet octet2;
        private IPOctet octet3;
        private IPOctet octet4;

        private static final String NETWORK_MASK_CHAR = "/24";

        public IPAddress(String value) throws Exception{
            value = cutOffNetworkMask(value);
            String[] octets = value.split("\\.");
            if (octets.length < 4) throw new Exception("Invalid input value. Too few octets.");
            octet1 = new IPOctet(octets[0]);
            octet2 = new IPOctet(octets[1]);
            octet3 = new IPOctet(octets[2]);
            octet4 = new IPOctet(octets[3]);
        }

        public boolean hasMatchOf(IPAddress another){
            if (!octet1.isMatching(another.getOctet1())) return false;
            if (!octet2.isMatching(another.getOctet2())) return false;
            if (!octet3.isMatching(another.getOctet3())) return false;
            if (!octet4.isMatching(another.getOctet4())) return false;
            return true;
        }

        public IPOctet getOctet1(){ return octet1; }
        public IPOctet getOctet2(){ return octet2; }
        public IPOctet getOctet3(){ return octet3; }
        public IPOctet getOctet4(){ return octet4; }

        private static String cutOffNetworkMask(String base){
            int index = base.indexOf(NETWORK_MASK_CHAR);
            try{
                if (index > -1) base = base.substring(0, index);
            }catch(IndexOutOfBoundsException ignored){}
            return base;
        }

    }