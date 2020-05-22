public static void main(String[] args)
{
    String signal[] = {"x",  "y", "y",  "C", "C", "z","C","C","x","C"};
    int time[] = { 2,    5,   1,   4,   7,   8,  2,  6,  4,  3 };
    int i=0;
    while (i < signal.length)
    {
        switch(signal[i])
        {

            case "x":
            {
                System.out.print("x = ");
                int sum = time[i];
                if(signal[i+1] == "C")
                {
                    i++;
                    while(i < signal.length && signal[i] == "C" )
                    {
                        sum += time[i];
                        i++;
                    }
                }
                else i++;
                System.out.print(sum + " ");

                break;
            }
            case "y":
            {
                System.out.print("y = ");
                int sum = time[i];
                if(signal[i+1] == "C")
                {
                    i++;
                    while(i < signal.length && signal[i] == "C" )
                    {
                        sum += time[i];
                        i++;
                    }
                }
                else i++;
                System.out.print(sum + " ");

                break;
            }
            case "z":
            {
                System.out.print("z = ");
                int sum = time[i];
                if(signal[i+1] == "C")
                {
                    i++;
                    while(i < signal.length && signal[i] == "C" )
                    {
                        sum += time[i];
                        i++;
                    }
                }
                else i++;
                System.out.print(sum + " ");

                break;
            }
        }
    }

}