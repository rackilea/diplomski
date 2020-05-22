public int randomFunc()
{
  final Random randomGenerator = new Random();
  int chance = randomGenerator.nextInt(10);
  return chance > 0 ? 2 : 4;
}