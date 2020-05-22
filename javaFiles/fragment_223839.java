public class HumansAndAnimals
{
  static String animalList[] = { "frog", "dog", "rabbit", "donkey", "cow", "chicken" };
  static String humanList[] = { "man", "woman", "child", "grandpa", "grandma", "baby" }; 

  static String animal1; static String animal2; static String animal3;

  static String human1; static String human2; static String human3;

  public static void main(String[] args)
  {
    animal1 = chooseFromArray(animalList);
    System.out.println("First animal: " + animal1);

    human1 = chooseFromArray(humanList);
    System.out.println("First human: " + human1);
  }

  private static String chooseFromArray(String[] arr) {
    return arr[(byte)(Math.random()*arr.length)];
  }
}