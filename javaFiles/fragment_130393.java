Scanner k = new Scanner(System.in);
        String C1, C2, C2a, C3, C3a, C3b, C3c;
        System.out.println("Ya arr a captain pirate on these high seas! Aboard the ship that yar father made, the M.M. Big Boy.");
        System.out.println("First order of business, is choosing your Pirate Name! What is yarr real name?");
        String name = k.nextLine();
        String Pn = "Capn Cornelious Coxswain, The Hatless";

        ///Start of story
        System.out.println("Scupper that sailor! We'll call you " + Pn);
        System.out.println("Arr ye wondering why yer called Hatless? You have NO hats. So little amounts of hats. Literally 0 hats.");
        System.out.println("Yee and yer crew be lookin for any booty to steal, as well as gold and treasure!");
        System.out.println("'Look smartly Sir!' yells one of yer sailors. 'A darkness approaches starboard!'.");
        System.out.println("You look round the deck as yer biggest fear comes to life. A giant squid begins to wrestle the ship!");
        System.out.println("The crew starts to panic as the ship gets dragged into the water. 'Show a leg boys!' is the last thing you say before being dragged into the darkness.");
        System.out.println("She be lookin like the end for ol' " + Pn + ", until a giant sea turtle swims up to ye.");
        System.out.println("'I am King Randy Myrtle, The Friendly Sea Turtle.' Says Randy. 'I can take you to an island, climb aboard!'");

        System.out.println("Do you climb aboard King Randy Myrtle, The Friendly Sea Turtle? (Yes or No)");

        ////First choice "Yes"
        C1 = k.next();
        if (C1.equalsIgnoreCase("yes")) {
            System.out.println("King Randy takes you to the surface. 'I know of two Islands, the first being the Island of the screaming crabs,");
            System.out.println("or the Island of the Pun Telling Trees. which would you like to go to?' (Crab or Tree)");

            ////Second choice "Crab"
            C2 = k.next();
            if (C2.equalsIgnoreCase("Crab")) {

                System.out.println("'Okay! Here we go!'. King Randy takes off towards a distant land. You come about to a crab staring you dead in the face.");
                System.out.println("'Blast', you think to yourself. Ye see the crab take a lung of breath, waiting for the worst screamin crab ever recorded.");
                System.out.println("'CAPN CORNELIOUS COXSWAIN, THE HATLESS!'. The crab repeats, as it starts pinching your nose. Angered and afraid, you pick up a nearby rock.");
                System.out.println("Do you 'throw' the rock, or 'wait' for the crab to scream again?");

                ////Third choice "Throw"
                C3 = k.next();
                if (C3.equalsIgnoreCase("Throw")) {
                    System.out.println("You throw the rock somewhere in the distance. Why wouldn't you you aim it at the crab?");
                    System.out.println("Now you're defenseless, and an idiot in the eyes of crabs. GAME OVER.");
                    System.out.println("Thank you for playing my adventure, press run to play again.");

                }
                ////Third Choice else "Wait"
                else if (C3.equalsIgnoreCase("Wait")) {
                    System.out.println("You wait, and the crab starts screaming again. You notice that the tones ");
                    System.out.println("are in a pattern, so you sing along. The beautiful harmonies intrigue ");
                    System.out.println("the rest of the crabs, who then celebrate your presence. You win the island!");
                    System.out.println("Thank you for playing my adventure, press run to play again.");

                }
            }
            ////Second Choice else "Tree"
            else if (C2.equalsIgnoreCase("Tree")) {
                System.out.println("'Fantastic choice!' says Randy. He takes you to the island, where you hear lots of moans and small chuckles. You reach the sand, and walk up to a line of trees.");
                System.out.println("'Is that a pirate over there?' asks one of the trees. 'Yes I think so! Hey I heard they were really good singers!' incorrectly states another.");
                System.out.println("'Why is that?' you ask. 'Because they can always hit the HIGH C'S!!' says the tree, bursting with laughter. 'I guess that's a little funny' you mumble to yourself.");
                System.out.println("'Oh you're in for a real TREEt then Cap'n! I have one for you.'Why should you pull your plate closer while eating spaghetti?' asks the tree. Do you answer? (Yes or no)");

                ////Third Choice 2 "Yes"
                C3a = k.next();
                if (C3a.equalsIgnoreCase("yes")) {
                    System.out.println("'So you don't spill any of it?' you say, immediately regretting your answer. You know that the tree is staring at you, even if it doesn't have eyes.");
                    System.out.println("'That was MY PUN.' exclaims the tree. 'NOW YOU WILL NEVER KNOW THE ANSWER, and are BANISHED from my PUNS, STINKy pirate.' Knowing you will never hear the pun, fills you with sadness. ");
                    System.out.println("Your eyes begin to sting, and you start shedding tears of soy. GAME OVER.");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                }
                ////Third Choice 2 else "No"
                else if (C3a.equalsIgnoreCase("no")) {
                    System.out.println("'Hm I'm not sure!' you say. The tree chuckles harmoniously. 'So you'll get less-on-ya! HAHAHAHA!'. After contemplating your death from this joke, you decide to laugh with the tree.");
                    System.out.println("Knowing that you will be great friends, fills you with determination. YOU WIN!");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                } else {
                    System.out.println("That is not an option. Please hit \"run\" to try again.");
                }
            }
        }
        ////First Choice else "No"
        else if (C1.equalsIgnoreCase("no")) {
            System.out.println("'Well, SORRY for asking then.' says Randy. He swims away. Now you are sinking into the abyss. It doesn't look too good. When you look up, there is ");
            System.out.println("a shark and it's eating your mates! You look up and see a raft, you look down and see a little cave you could hide in. Do you 'swim', or 'hide'?");

            ////Second Choice 2 "Raft"
            C2a = k.next();
            if (C2a.equalsIgnoreCase("swim")) {
                System.out.println("You begin to swim, and the shark chases right after you! You are able to avoid it, and make it to the raft. You look down and see that the shark is not chasing you, ");
                System.out.println("but being chased himself! A blue whale swallows the shark whole as he screams for his wife. You see a paddle out in the water, do you try to 'grab' it before Moby Dick himself ");
                System.out.println("consumes you? Or do you 'stay' on the raft?");

////Third Choice 3 "Grab"
                C3b = k.next();
                if (C3b.equalsIgnoreCase("grab")) {
                    System.out.println("You lunge for the paddle! Now is your time, and you start swimming faster and harder than ever before. You reach for it and - you got it! As you start to swim towards ");
                    System.out.println("the raft. You make it, and start paddling to a nearby island. From where you are, you think you can hear a mixture of screaming and laughing... YOU WIN!");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                }
                ////Third Choice 3 "Stay"
                else if (C3b.equalsIgnoreCase("stay")) {
                    System.out.println("You decide to stay on the raft. Good choice, that paddle looked real dangerous. The whale can not get close enough due to the wreckage to attack you.");
                    System.out.println("In a fit of fury, the whale breaches the water and says 'Caw! Caw!'. The whale then starts to fly! He is getting a LOT of air, but he is coming your way.  ");
                    System.out.println("You realize that there is nothing you can do but watch the beauty of the whale come crashing down onto you. 'Take me as I am' are the last words to leave " + Pn + "'s mouth. THE END.");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                }
            }

            ////Third Choice 4 "Swim"
            if (C2a.equalsIgnoreCase("hide")) {
                System.out.println("You swim to the nearby cave. Inside is a beautiful mermaid. 'Hello' says the mermaid. You lean in to say hi, but you trip on a big, glossy, wet stack of the movie ");
                System.out.println("'The Ocean of Trumpets'. There is at least sixty of them. 'Sorry!' you exclaim. 'Oh, that's okay. You've just stepped on my big, glossy, wet stack of my favorite movie, ");
                System.out.println("'The Ocean of Trumpets'. Say, how many do you think I have?'. The wetness of the DVD's entice you. You read the layout of the cave, and realize ");
                System.out.println("that you could EASILY run away and STEAL a DVD. So, would you like to take a 'guess', or take a 'DVD'?");

                //// Third Choice 5 "60"
                C3c = k.next();
                if (C3c.equalsIgnoreCase("DVD")) {
                    System.out.println("You start screaming the tune of 'We Are The Champions' to distract the mermaid. It serenades her into a deep slumber. You STEAL a DVD, Indiana Jones style. However, ");
                    System.out.println("you have not brought anything to replace the DVD with. The entire cave begins to rumble, and you are suddenly about to be crushed by a rolling boulder, also ");
                    System.out.println("Indiana Jones style! The only difference is you get crushed by the boulder, THE END.");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                }
                ////Third Choice 6 "guess"
                else if (C3c.equalsIgnoreCase("guess")) {
                    System.out.println("Please insert your guess into me! (Number)");
                    int num = k.nextInt();
                    double bignum = Math.PI * Math.pow(num, 2);
                    System.out.println("'Hmmm my guess is " + num + "!'. 'So close!' says the mermaid. But the answer is actually " + bignum + "! I'm sorry but you aren't qualified to touch my DVD's.'");
                    System.out.println(" You gaze at the wet pile of DVD's and cry tears of soy. When it hits the water, you realize what your life has become. Seeing that murky reflection fills ");
                    System.out.println("you with sadness. GAME OVER.");
                    System.out.println("Thank you for playing my adventure, press run to play again.");
                } else {
                    System.out.println("That is not an option. Please run again.");
                }

            }
        }