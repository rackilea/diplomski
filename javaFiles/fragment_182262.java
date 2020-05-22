public SpannableStringBuilder setWord(String text)
    {
        tokenList = new ArrayList<String>();

        startIndext = 0;
        endIndex = 0;
        isEnglish = false;

        stringBuilder = new SpannableStringBuilder("");

        Log.i("CustomUrduKeyBoard","inside setWord text is: "+text+" stringBuilder: "+stringBuilder);
        if(text == null)
        {

        } else 
        {

            for (int i = 0; i < text.length(); i++) 
            {
//              System.out.println(text.charAt(i) + "-Code:" + (int) text.charAt(i)
//                      + "-" + Integer.toHexString(text.charAt(i)));
                if (text.charAt(i) < 255) 
                {
                    if (!isEnglish) 
                    {
                        endIndex = i;
                        String token = text.substring(startIndext, endIndex);

                        SpannableStringBuilder urduBLD;
                        urduBLD = new SpannableStringBuilder("");
                        urduBLD.append(token);

                        urduBLD.setSpan(new CustomTypefaceSpan("", urduFont),0,urduBLD.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        stringBuilder.append(urduBLD);
                        tokenList.add(urduBLD.toString());
                        startIndext = endIndex;
                    }
                    isEnglish = true;
                    // english
                    continue;
                } else 
                {
                    if (isEnglish) 
                    {
                        endIndex = i;
                        String token = text.substring(startIndext, endIndex);

                        SpannableStringBuilder engBLD;
                        engBLD = new SpannableStringBuilder("");
                        engBLD.append(token);

                        engBLD.setSpan(new CustomTypefaceSpan("", englishFont),0,engBLD.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        stringBuilder.append(engBLD);
                        tokenList.add(engBLD.toString());
                        startIndext = endIndex;
                    }
                    isEnglish = false;
                    // urdu
                    continue;
                }
            }

            String token = text.substring(startIndext, text.length());

            for (int i = 0; i < token.length(); i++) 
            {
                if (token.charAt(i) < 255) 
                {

                    SpannableStringBuilder urduBLD;
                    urduBLD = new SpannableStringBuilder("");
                    urduBLD.append(token);

                    urduBLD.setSpan(new CustomTypefaceSpan("", englishFont),0,urduBLD.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    stringBuilder.append(urduBLD);
                    tokenList.add(urduBLD.toString());

                    break;
                } else
                {

                    SpannableStringBuilder engBLD;
                    engBLD = new SpannableStringBuilder("");
                    engBLD.append(token);

                    engBLD.setSpan(new CustomTypefaceSpan("", urduFont),0,engBLD.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    stringBuilder.append(engBLD);
                    tokenList.add(engBLD.toString());

                    break;
                }
            }

        }

        return stringBuilder;
    }