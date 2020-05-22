while (sentence.indexOf(lookFor) == 0)
    sentence = sentence.substring(1);
while (sentence.indexOf(lookFor) > 0)
{
    sentence = sentence.substring(0, sentence.indexOf(lookFor)-1)+
               sentence.substring(sentence.indexOf(lookFor)+1);
}
return sentence;