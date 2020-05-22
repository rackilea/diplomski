string[] methodNames = new string{}["ones","twos",....];
for(string method : methodNames)
{
    Method method = this.getClass().getMethod(dice_values.getClass());
    each_score = method.Invoke(this,dice_values);
    total_score += each_score;
    end_scores += String.valueOf(each_score) + " ";
}