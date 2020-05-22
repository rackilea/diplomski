// might be more than 10 ImageButtons, with only 10 images
for (ImageButton imageButton : imageButtons)  
   imageButton.putImage(randomImage.next());

...

public class RandomImage {
   private final List<Image> shuffledImages;
   private int currentIndex;

   public RandomImage(List<Image> images) {
      shuffledImages = new ArrayList<>(images.size());
      shuffledImages.addAll(images);
      currentIndex = -1;
   }

   public Image next() {
      currentIndex++;
      if (currentIndex % shuffledImages.size() == 0) {
         currentIndex = 0;
         Collections.shuffle(shuffledImages);
      }
      return shuffledImages[currentIndex];
   }
}