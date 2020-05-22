package somepackage;

public final class WebConsts {

   public static final int MAX_LENGTH = 20;

   private WebConsts(){}
}

<input id="name" type="text" th:maxlength="${T(somepackage.WebConsts).MAX_LENGTH}" />