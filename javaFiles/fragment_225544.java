public static void main(String[] args) {
        String LCName = "4BI C 06W 045  PNL 02 E";
        String first = LCName.split("  ")[0] + " ";
        String second = LCName.split("  ")[1].replaceAll("\\s+", "");
        System.out.println(first.concat(second));
    }