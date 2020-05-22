public class InterfaceTest {
    interface Gift  { void present(); }
    interface Guest { boolean present(); }

    interface Presentable extends Gift, Guest { } // DOES NOT COMPILE!!!
    // "types InterfaceTest.Guest and InterfaceTest.Gift are incompatible;
    //  both define present(), but with unrelated return types"
}