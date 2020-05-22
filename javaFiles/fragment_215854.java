public class TokenArrayCreator {

    public final int TOKEN_WIDTH = 35;

    private ArrayList<Rectangle> tokenarr;

    public TokenArrayCreator() {
    }

    public void ArrayCreator() {

        tokenarr = new ArrayList<Rectangle>();
        Random random = new Random();

        int requiredObjectCount = 11;

        while (tokenarr.size() < requiredObjectCount) {

            for (int i = 0; i < requiredObjectCount - tokenarr.size(); i++) {
                Rectangle token = new Rectangle(random.nextInt(300), random.nextInt(300), 35, 35);
                tokenarr.add(token);
            }

            for (int i = 0; i < tokenarr.size(); i++) // make two list i and j && if i != j
            {
                for (int j = 0; j < tokenarr.size(); j++) {
                    if (i != j) {
                        if (tokenarr.get(i).intersects(tokenarr.get(j))) {
                            tokenarr.remove(j);
                        }
                    }
                }
            }

        }

    }

    public ArrayList<Rectangle> getList() {
        return tokenarr;
    }

}