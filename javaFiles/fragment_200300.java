String []array = new String[]{"foo","bar","the_string_you_are_looking_for"};

int index = -1;
for (int i = 0; i < array.length; ++i)
{
   if (array[i].contains("the_string_you_are_looking_for"))
   {
       index = i;
       break;
   }
}