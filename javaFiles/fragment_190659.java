public static void main(String[] args) {
        String mydata = "Arsenal FC               4-3  Leicester City";
        Pattern pattern = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}");
        Matcher matcher = pattern.matcher(mydata);
        String result = "";
        if (matcher.find()) {
            result = matcher.group();
            mydata = mydata.replace(result, "#");
        }
        String[] dataSplit = mydata.split("#");

        HashMap<String, String> match = new HashMap<>();

        match.put("local", dataSplit[0].trim());
        match.put("visitor", dataSplit[1].trim());
        match.put("result", result);

        System.out.println(match.get("local"));
        System.out.println(match.get("result"));
        System.out.println(match.get("visitor"));
}