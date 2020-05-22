public enum BlockManValEnum {

    SecurityID("SecurityID"),
    BlockStatus("BlockStatus"),
    Side("Side"),
    GTBookingInst("GTBookingInst");

    private static Set<String> names = new HashSet<String> {{
      for(BlockManValEnum e : BlockManvalEnum.values()) {
         add(e.toString());
      }
    }};

    private static boolean contains(String name) {
      return names.contains(name);
    }

    private String name;

    private BlockManValEnum(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}