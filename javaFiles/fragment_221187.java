List<Integer> musicIcons = new ArrayList<>();

final TypedArray typedArray = getResources().obtainTypedArray(R.array.musicIcon);

for(int i = 0; i < typedArray.length(); i++) {
    musicIcons.add(typedArray.getResourceId(i, -1);
}

typedArray.recycle();