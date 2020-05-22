private Random random = new Random();
private int n; // Can't decide up here, since array is not declared / initialized

private String randText;

public YourObject(Context contex) {
    String[] string = context.getResources().getStringArray(R.array.text);
    n = random.nextInt(string.length);     // <--- Do it here instead.
    randText = "Stuff to display " + string[n] +".";
}

public String getRandText {
    return randText;
}