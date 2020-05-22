String yourAccountTypeInString;
               if (myAccount.accountType == yourAccountType)
                   yourAccountTypeInString= "theStringOfAccountType";
         // use else if 

               int pos = typeOfAccountAdapter.getPosition(yourAccountTypeInString);
               typeOfAccount.setSelection(pos);