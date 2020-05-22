...
  org.armedbear.lisp.Package defaultPackage
    = Packages.findPackage("CL-USER");
  Symbol bankAccountImplSymbol
    = defaultPackage.findAccessibleSymbol("*BANK-ACCOUNT-IMPL*");
  LispObject value = bankAccountImplSymbol.symbolValue();
  Object object =  ((JavaObject) value).getObject();
  BankAccount account = (BankAccount) object;
  System.out.println("Initial balance: " + account.getBalance());
  account.withdraw(500);
  System.out.println("After withdrawing 500: " + account.getBalance());
  ...