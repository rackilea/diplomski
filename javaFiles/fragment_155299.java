public class WordClass extends SomeClass<Word>{

  public Word someMethod(){
    // since the generic type is now defined as Word, you can reference it as such
    Word wordObject = super.getItem();
    return wordObject;
  }

}