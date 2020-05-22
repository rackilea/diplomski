public static void main(String[] args) throws Exception {

    List<String> toOutput = new ArrayList<String>();
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    String line;
    while ((line = br.readLine()) != null) {
        boolean add = true;

        for (int i = 0; i < toOutput.size(); i++) {
            if (toOutput.get(i).contains(line)) {
                toOutput.remove(i);
            } else if (line.contains(toOutput.get(i))) {
                add = false;
                break;
            }
        }

        if (add) {
            toOutput.add(line);
        }
    }
    br.close();

    for (String s : toOutput) {
        System.out.println(s);
    }
}