interface InformationElement<T> {
    public String getValue (T param);
}

class NbFileLineInformationElement implements InformationElement<File>{
    @Override
    public String getValue(File param) {
          return /*same code as in getLineNumber(myFile)*/;
    }
}

class UserInformationElement implements InformationElement<UserRepository>{
      @Override
      public String getValue(UserRepository param) {
         return /*same code as in getUsersName(myDBRepository)*/;
   }
}