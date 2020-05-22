public class FacebookLite {

    private String name;
    private int age;
    private String mood;
    private int fIdx;
    private String[] fArr;
    private int pIdx;
    private String[] pArr;
    private boolean ageVis;
    private boolean fVis;
    private boolean pVis;
    private boolean mVis;

    public FacebookLite(String name, int age) {

        this.name = name;
        this.age = age;
        mood = "";
        fIdx = 0;
        fArr = new String[200];
        pIdx = 0;
        pArr = new String[200];
        ageVis = true;
        for (int i = 0; i < fArr.length; i++) {

            fArr[i] = "";

            pArr[i] = "";

        }

    }

    public void printProfile() {

        if (ageVis) {
            System.out.print(age);
        }

        printFriends();
        printPost("");
    }

    private void printFriends() {

        int idx = 0;

        while (!fArr[idx].equals("")) {

            System.out.println(fArr[idx]);
            idx++;
        }
    }

    public void printPost(String str) {

        if (pIdx < pArr.length) {
            pArr[pIdx] = str;
            pIdx++;
        }
    }

    public void removeLastPost() {

        if (pIdx > 0) {

            pArr[pIdx - 1] = "";

            pIdx--;

        } else {

            System.out.print("sorry no posts to remove");
        }
    }

    public void addFriend(String friend) {

        if (fIdx < fArr.length) {
            String temp = fArr[fIdx];
            fIdx++;
        }

    }

    public void toggleAgeVis() {

        ageVis = !ageVis;

    }

    public void togglefVis() {

        fVis = !fVis;

    }

    public void togglepVis() {

        pVis = !pVis;

    }

    public void togglemVis() {

        mVis = !mVis;

    }

}