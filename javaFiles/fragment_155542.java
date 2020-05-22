public class Identifiable { }
    public class SampleUser extends Identifiable { }
    public class ExampleUser extends Identifiable { }

    public class UserService
    {
        public int SampleUserSecurity = 0;
        //Or an array/dictionary structure

        public int GetSecurityLevel(Identifiable user)
        {
            if(user instanceof SampleUser)
            {
                return SampleUserSecurity;
            }
        }

        public SampleUser CreateSampleUser()
        {
            return new SampleUser();
        }

        public ExampleUser CreateExampleUser()
        {
            return new ExampleUser();
        }
    }