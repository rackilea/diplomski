public static void main(String args[]) {
    String operation = "55*6-66-33+15/99";
    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < operation.length(); i++) {
        if (!list.isEmpty()) {
            if (operation.charAt(i) >= '0' && operation.charAt(i) <= '9') {
                String str = list.get(list.size() - 1);
                if (testInteger(str)) {
                    int d = Integer.parseInt(str);
                    int d2 = Integer.parseInt(operation.charAt(i) + "");
                    String s = (d * 10 + d2) + "";
                    list.set(list.size() - 1, s);
                } else {
                    list.add(operation.charAt(i) + "");
                }
            } else {
                list.add(operation.charAt(i) + "");
            }
        } else {
            list.add(operation.charAt(i) + "");
        }
    }