final class StudentAndSubjects extends JavaScriptObject {
  protected StudentAndSubjects() { }

  public native Student getStudent() /*-{ return this.student; }-*/;
  public native JsArray<Subject> getSubjects() /*-{ return this.subjects; }-*/;
}

final class Student extends JavaScriptObject {
  protected Student() { }

  public native String getField1() /*-{ return this.field1; }-*/;
  public native String getField2() /*-{ return this.field2; }-*/;
  …
}

final class Subject extends JavaScriptObject {
  protected Subject() { }

  …
}