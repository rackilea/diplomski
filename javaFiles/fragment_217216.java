@objc public class Explore : NSObject
{
    @objc private class notAnAnonButPrivateClass : NSObject, Executer
    {
        func execute() -> Void
        {
            print("we did it!")
        }
    }

    var executer : Executer = notAnAnonButPrivateClass()