ch = char_array[i]; 
if(charCounter.containsKey(ch)){
     charCounter.put(ch, charCounter.get(ch)+1);
}
else
{
    charCounter.put(ch, 1);
}