boolean same = false;
int sequenceLength = 0;
Integer sequenceInteger = null; 

for (int i = 1; i < numbers.size(); i++)
        { 
            if(numbers.get(i).equals(numbers.get(i-1)))
                {
                      same = true;
                      sequenceLength++;
                }      
            else(if same == true)
                {
                      sequenceInteger = new Integer(sequenceLength);
                      //add sequenceInteger to length and numbers.get(i-1) to value 
                      same = false;
                      sequenceLength = 0;
                }
            // else do nothing since same is false, which means that the current
            // element is different from the previous and the previous is 
            // different the one before that, so there are no new values to store
        }
// end of list reached
(if same == true)
{
      sequenceInteger = new Integer(sequenceLength);
      //add sequenceInteger to length and numbers.get(i-1) to value 
      same = false;
}