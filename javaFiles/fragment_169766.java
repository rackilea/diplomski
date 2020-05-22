switch(op)
                {
                case '+':
                    stack.push((one + two) + "");
                    break;
                case '-':
                    stack.push((one - two) + "");
                    break;
                case '*':
                    stack.push((one * two) + "");
                    break;
                case '/':
                    stack.push((one / two) + "");
                    break;
                }