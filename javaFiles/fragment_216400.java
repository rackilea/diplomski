public static Message[] removeFromArray(Message[] array, int index)
{
    int length = array.length;
    if(index < 0 || index >= length) return array;

    Message temp = new Message[length - 1];
    int counter = 0;
    for(int i = 0; i < length; i++)
    {
        if(i == index) continue;
        temp[counter++] = array[i];
    }
    return temp;
}

// ...

Message[] messages = getMessageArraySomeHow();
messages = removeFromArray(messages, 1);