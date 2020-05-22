public static void main(String args[]) {
        String value="xyz";
        List<String> dataList = new ArrayList<>();
        dataList.add("abc");
        dataList.add("def");
        dataList.add("ghi");
        dataList.add("xyz");
        dataList.add("jkl");
        dataList.add("mno");



        dataList.stream().filter(obj -> obj.equals(value)).forEach(System.out::println);
    }