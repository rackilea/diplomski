for (String word : words)
                {
                    if (word.matches(pattern))
                    {
                        System.out.println(word);
                        if (!searched.add(word))
                            System.out.println("Word already in list");
                        }
                    }