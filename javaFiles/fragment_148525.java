ConstantState mine = bun_picture.getConstantState();
ConstantState other = ContextCompat.getDrawable(context, R.drawable.rawbun).getConstantState();

if (mine.equals(other)) {
    // they are the same
}