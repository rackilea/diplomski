for (int j = 0; j < token.length(); ++j)
            {
                    char tempStk = stk.pop(); //removing them one at a time and checking if they are equal and incrementing counter
                    char tempQue = que.remove();

                    if (tempStk != tempQue)
                        break;
            }

            if (j == token.length())