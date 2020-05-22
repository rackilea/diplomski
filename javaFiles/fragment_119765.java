System.out.println("Enter word: ");
                    Scanner scanner = new Scanner(System.in);
                    String word = scanner.nextLine();
                    int i = 0;
                    boolean found=false;
                    for (i = 0; i < word.length()-1; i++) {
                        if (word.charAt(i) == word.charAt(i+1)) {
                            found=true;
                            break;
                        } 
                        }
                    if(found) {
                        System.out.println("word contain double letter");
                    }else
                        System.out.println("normal word found");