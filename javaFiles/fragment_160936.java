public abstract class IActivation
{
    public abstract double func(double inputput);

    public class S1 : IActivation
    {
        public override double func(double input)
        {
            if (input > 0) return 1.0;
            return 0.0;
        }
    }
}