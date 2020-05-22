public static void main(String[] args) {
        printIPs("192.148.233.0", "192.148.245.3", 32);

    }

    public static void printIPs(String start, String end, int mask) {
        LongStream.rangeClosed(toLong(start, mask), toLong(end, mask))
                .mapToObj(ip-> toIP(ip, mask))
                .forEach(System.out::println);

    }

    public static String toIP(long lv, int mask) {
        lv <<= (32-mask);
        String ip = String.join(".",
                Long.toString((lv >> 24) & 0xFF),
                Long.toString((lv >> 16) & 0xFF),
                Long.toString((lv >> 8) & 0xFF),
                Long.toString(lv & 0xFF));
        return ip;
    }

    public static long toLong(String ip, int mask) {
        String[] n = ip.split("\\.");

        long v = Integer.valueOf(n[0]);
        v <<= 8;
        v |= Integer.valueOf(n[1]);
        v <<= 8;
        v |= Integer.valueOf(n[2]);
        v <<= 8;
        v |= Integer.valueOf(n[3]);

        return v >> (32-mask);
    }
}
}