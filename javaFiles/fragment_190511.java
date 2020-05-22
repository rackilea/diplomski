String text1 = "D8516025209        StackOverflow is good.";
    String text2 = "D3516025204        StackOverflow Nice to see you.";

    int minimum = Math.min(text1.length(), text2.length());
    int maximum = Math.max(text1.length(), text2.length());

    StringBuilder stringBuilder = new StringBuilder("Difference of indices from s1 and s2: ");
    StringBuilder text1Diff = new StringBuilder();
    StringBuilder text2Diff = new StringBuilder();
    int index = 0;

    while (index < minimum)
    {
        if (text1.charAt(index) != text2.charAt(index))
        {
            stringBuilder.append(stringBuilder.length() > 0 ? ", " : "").append(index + 1).append(" - ");
            text1Diff.append(text1Diff.length() > 0 ? ", " : "");
            text2Diff.append(text2Diff.length() > 0 ? ", " : "");

            while ((index < minimum) && (text1.charAt(index) != text2.charAt(index)))
            {
                text1Diff.append(text1.charAt(index));
                text2Diff.append(text2.charAt(index));
                index++;
            }

            if (index == minimum)
            {
                stringBuilder.append(maximum);
                index = maximum;

                if (maximum == text1.length())
                    text1Diff.append(text1.substring(minimum));
                else
                    text2Diff.append(text2.substring(minimum));
            }
            else
                stringBuilder.append(index);
        }
        index++;
    }

    if (minimum != maximum && index < maximum)
    {
        stringBuilder.append(stringBuilder.length() > 0 ? ", " : "").append(minimum + 1).append(" - ").append(maximum);

        if (maximum == text1.length())
            text1Diff.append(text1.substring(minimum));
        else
            text2Diff.append(text2.substring(minimum));
    }

    System.out.println(stringBuilder.toString());
    System.out.println("Differences: ");
    System.out.println(text1Diff.toString());
    System.out.println(text2Diff.toString());