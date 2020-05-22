if ((death - 1 == counter) && (a >= p)) {
                    System.out.format("Your uncle dies in week %2d. But you were lucky and received an extra " +
                            "$%.2f dollars.\n", death, ((death * initial) - ((Math.pow(2, (death - 1)) / 100))));
                }else if(p > a) {
                    System.out.format("Your uncle dies in week %2d. But you were unlucky and missed an extra " +
                            "$%.2f dollars.\n", death, (p - a));
                    break;
                }