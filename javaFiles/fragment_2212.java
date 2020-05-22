int current_consecutive_ones = 0;
int best_consecutive_ones = 0;
for(int i = 0; i < binary.length(); i++)
{
    if (binary.charAt(i) == '1')
        current_consecutive_ones++;
    else
        current_consecutive_ones = 0;

    if (current_consecutive_ones > best_consecutive_ones)
        best_consecutive_ones = current_consecutive_ones;
}
System.out.println(best_consecutive_ones);