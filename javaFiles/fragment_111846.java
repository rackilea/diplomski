mean1 = sum/durations.size();
double var = 0;
for (int toCalcSD = 0; toCalcSD < durations.size(); toCalcSD++)
{
  var += ((durations.get(toCalcSD) - mean1) *
         (durations.get(toCalcSD) - mean1)) / (durations.size() - 1);
}
sd = Math.sqrt(var);