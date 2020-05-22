for(int k = 0; k <= words.length - 1;k++)
                {
                    if(words[k].matches(pattern))
                    {
                        System.out.println(words[k]);
                        if(!searched.contains(words[k]))
                        {
                            if(temp.contains(words[k]))
                                System.out.println("Word already in list");
                            else
                            {
                                temp.add(words[k]); 
                            }
                        }
                    }