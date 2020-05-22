Outer outer = ...
// Get the declared (private) field personal from the public class Outer
Field  personalField = Outer.class.getDeclaredField("personal");
// Make it accessible otherwise you won't be able to get the value as it is private
personalField.setAccessible(true);
// Get the value of the field in case of the instance outer
Object personal =  personalField.get(outer);
// Get the declared (private) field innerPersonal from the private static class Inner
Field  innerPersonalField = personal.getClass().getDeclaredField("innerPersonal");
// Make it accessible otherwise you won't be able to get the value as it is private
innerPersonalField.setAccessible(true);
// Get the value of the field in case of the instance personal
Set<String> innerPersonal = (Set<String>)innerPersonalField.get(personal);