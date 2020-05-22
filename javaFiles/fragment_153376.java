class MyFactory {
   @Prefix("showUser")
   public PlaceTokenizer<ShowUserPlace> showUserPlace() {
      return new UserPlaceTokenizer<ShowUserPlace>() {
         protected ShowUserPlace createPlace(String id) {
            return new ShowUserPlace(id);
         }
      };
   }

   @Prefix("showUser")
   public PlaceTokenizer<EditUserPlace> showUserPlace() {
      return new UserPlaceTokenizer<EditUserPlace>() {
         protected EditUserPlace createPlace(String id) {
            return new EditUserPlace(id);
         }
      };
   }
}

abstract class UserPlaceTokenizer<P extends UserPlace> implements PlaceTokenizer<P> {
   public P getPlace(String token) {
      // shared logic between both places: parses ID (or whatever) from token
      return createPlace(id);
   }
   public String getToken(P place) {
      // shared logic between both places: build token out of place
      return token;
   }
   protected abstract P createPlace(String id);
}