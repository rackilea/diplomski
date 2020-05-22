case 3:
      System.out.println("[3] Delete an account has been selected");
      System.out.println("Enter the account ID: ");
      int accountNo = scan.nextInt();
      bankAccount = bank.getAccount(accountNo); // get bankAccount from account id
      bank.removeAccounts(bankProcess.removeAccount(bank.getAccounts(), bankAccount));
      break;