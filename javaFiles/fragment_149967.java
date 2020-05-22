import java.util.Random;

Random rand = new Random();
int percentage = 25; //Set this to whatever percentage you want.

public void onCreatureSpawn(CreatureSpawnEvent e) {
  //This will generate a number between 0 and 99 (inclusive)
  int generatedNumber = rand.nextInt(100);

  //If the generated number is smaller than the percentage you chose, you have "success".
  if(generatedNumber < percentage){
    addCharacteristic(creature, characteristic);
  }else{
    //Do whatever you need to normally.
  }
}