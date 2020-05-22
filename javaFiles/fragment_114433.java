ArrayList<String> temp = new ArrayList<>();   

public static void main(String[] args) {
        for (int q = 1; q < 3; q++) {

            temp = new ArrayList<>();

            switch (q) {
            case 1:
                temp.add("case1");
                methodA();
                list.add(temp);
                break;

            case 2:
                temp.add("case2");
                methodA();
                list.add(temp);
                break;
            }
        }