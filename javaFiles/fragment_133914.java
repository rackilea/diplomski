String text = area.getText();
char[] parts = text.toCharArray();
int startPosition = 0;

for(int i = position - 1; i >= 0; i--)
{
    if(parts[i] == ' ')
    {
        startPosition = i;
        break;
    }
}

System.out.println(text.substring(startPosition, position - 1));