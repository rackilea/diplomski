public boolean uttak(int species, int kroner, int skilling) throws WithdrawalException { // checked exceptions need to be declared in the throws clause 
     if (species<=this.species && kroner<=this.kroner && skilling <=this.skilling)
     {
         this.species -=species;
         this.kroner -=kroner;
         this.skilling -=skilling;
         return true;
     }
     else
         // throw an exception
         throw new WithdrawalException("Withdrawals can not be done when there is insufficient money in the machine.");
}