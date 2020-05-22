public class Days
{

    enum DAY
    {
        MON("Monday"),
        TUE("Tuesday"),
        WED("Wednesday"),
        THU("Thursday"),
        FRI("Friday"),
        SAT("Saturday"),
        SUN("Sunday");

        private String name;

        private DAY(String name)
        {
            this.name= name;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public DAY add(int days)
        {
            int posMod = (this.ordinal() + days) % values().length;
            if (posMod < 0)
            {
                posMod += values().length;
            }
            return DAY.values()[posMod];
        }
    }

    public static void main(String[] args)
    {
        DAY a = DAY.values()[0];
        System.out.println(a);
        System.out.println(a.add(-2));
        System.out.println(a.add(0));
        System.out.println(a.add(-8));
    }

}