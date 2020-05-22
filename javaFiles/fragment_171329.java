public String fullPhoneNumber(String initialPhoneNumber)
{
  StringBuilder result;
  result = new StringBuilder();

  for (int i = 0; i < initialPhoneNumber.length(); i++)
  {
    char letter = Character.toUpperCase(initialPhoneNumber.charAt(i));
    switch (letter)
    {
      case 'A':
      case 'B':
      case 'C':
        letter = '2';
        break;
      case 'D':
      case 'E':
      case 'F':
        letter = '3';
        break;
      case 'G':
      case 'H':
      case 'I':
        letter = '4';
        break;
      case 'J':
      case 'K':
      case 'L':
        letter = '5';
        break;
      case 'M':
      case 'N':
      case 'O':
        letter = '6';
        break;
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
        letter = '7';
        break;
      case 'T':
      case 'U':
      case 'V':
        letter = '8';
        break;
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
        letter = '9';
        break;
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case '-':
        break;
      default:
        throw new IllegalArgumentException("");
    }

    result.append(letter);

  } // for

  return (result.toString());

} // fullPhoneNumber