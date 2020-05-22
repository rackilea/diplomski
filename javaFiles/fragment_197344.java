//...

final TypedArray ImageArray = getResources().obtainTypedArray(R.array.PairImages);

//Just a holder for random numbers. 
//If you add/remove an image make sure you change the 8...
ArrayList<Integer> randomNumbers = new ArrayList<>();
for (int i = 0; i < 8; i++){
    randomNumbers.add(i);
}
Collections.shuffle(randomNumbers);
int i = 0;


FirstImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
SecondImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
ThirdImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
FourthImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
FifthImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
SixthImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
SeventhImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));
EightImageCard.setImageResource(ImageArray.getResourceId(randomNumbers.get(i++), -1));

//...